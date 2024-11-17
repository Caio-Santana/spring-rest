package com.samsoftware.quickpoll.controller;

import com.samsoftware.quickpoll.domain.Poll;
import com.samsoftware.quickpoll.exception.ResourceNotFoundException;
import com.samsoftware.quickpoll.repository.PollRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PollController {

    @Inject
    private PollRepository pollRepository;

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
//        return new ResponseEntity<>(allPolls, HttpStatus.OK);
        return ResponseEntity.ok(allPolls);
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        poll = pollRepository.save(poll);

        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) throws Exception {
        return ResponseEntity.ok(verifiyPoll(pollId));
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
}
