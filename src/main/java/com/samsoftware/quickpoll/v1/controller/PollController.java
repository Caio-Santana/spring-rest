package com.samsoftware.quickpoll.v1.controller;

import com.samsoftware.quickpoll.domain.Poll;
import com.samsoftware.quickpoll.dto.error.ErrorDetail;
import com.samsoftware.quickpoll.exception.ResourceNotFoundException;
import com.samsoftware.quickpoll.repository.PollRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController("pollControllerV1")
@RequestMapping("/v1")
public class PollController {

    @Inject
    private PollRepository pollRepository;

    @Operation(summary = "Retrieves all the polls")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found polls",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Poll.class))
                    )
            )
    })
    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
        for (Poll p : allPolls) {
            updatePollResourceWithLinks(p);
        }

//        return new ResponseEntity<>(allPolls, HttpStatus.OK);
        return ResponseEntity.ok(allPolls);
    }

    @Operation(
            summary = "Creates a new Poll",
            description = "The newly created pollId will be sent in the location response header",
            method = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Poll created",
                    content = {
                            @Content(schema = @Schema)
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error creating Poll",
                    content = @Content(schema = @Schema(implementation = ErrorDetail.class))
            )
    })
    @PostMapping("/polls")
    public ResponseEntity<Void> createPoll(@Valid @RequestBody Poll poll) {
        poll = pollRepository.save(poll);

        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getPollId())
                .toUri();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieves a Poll associated with the pollId")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the poll",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Poll.class))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Poll not found",
                    content = @Content
            )
    })
    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(
            @Parameter(
                    description = "id of the poll to be searched",
                    required = true
            ) @PathVariable Long pollId
    ) throws Exception {
        Poll poll = verifiyPoll(pollId);
        updatePollResourceWithLinks(poll);
        return ResponseEntity.ok(poll);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@Valid @RequestBody Poll poll, @PathVariable Long pollId) {
        verifiyPoll(pollId);
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifiyPoll(pollId);
        pollRepository.deleteById(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    protected Poll verifiyPoll(Long pollId) throws ResourceNotFoundException {
        Optional<Poll> poll = pollRepository.findById(pollId);
        if (poll.isEmpty()) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
        return poll.get();
    }

    private void updatePollResourceWithLinks(Poll poll) {
        poll.add(linkTo(methodOn(PollController.class).getAllPolls()).slash(poll.getPollId()).withSelfRel());
        poll.add(linkTo(methodOn(VoteController.class).getAllVotes(poll.getPollId())).withSelfRel());
        poll.add(linkTo(methodOn(ComputeResultController.class).computeResult(poll.getPollId())).withRel("compute-result"));
    }
}
