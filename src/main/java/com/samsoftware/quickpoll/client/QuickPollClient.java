package com.samsoftware.quickpoll.client;

import com.samsoftware.quickpoll.domain.Poll;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class QuickPollClient {

    private static final String QUICK_POLL_URI_V1 = "http://localhost:8080/v1/polls";
    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        QuickPollClient client = new QuickPollClient();

//        getOne - ok
//        Poll poll = client.getPollById(1L);
//        System.out.println(poll);

//        getAll - ok
//        System.out.println(client.getAllPolls());

//        create
//        Poll newPoll = new Poll();
//        newPoll.setQuestion("Pick a number.");
//        Set<Option> options = new HashSet<>();
//
//        Option option1 = new Option();
//        option1.setValue("1");
//        Option option2 = new Option();
//        option1.setValue("2");
//        Option option3 = new Option();
//        option1.setValue("3");
//
//        options.add(option1);
//        options.add(option2);
//        options.add(option3);
//
//        newPoll.setOptions(options);
//
//        URI pollLocation = client.createPoll(newPoll);
//        System.out.println("Newly created poll location: " + pollLocation);

        // update
//        newPoll.setId(1L);
//        client.updatePoll(newPoll);
//        System.out.println(client.getPollById(1L));

//        delete - ok
//        client.deletePoll(1L);
//        System.out.println(client.getAllPolls());
    }

    public Poll getPollById(Long pollId) {
        return restTemplate.getForObject(QUICK_POLL_URI_V1 + "/{pollId}", Poll.class, pollId);
    }

    public List<Poll> getAllPolls() {
        ParameterizedTypeReference<List<Poll>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<Poll>> responseEntity = restTemplate.exchange(QUICK_POLL_URI_V1, HttpMethod.GET, null, responseType);
        List<Poll> allPolls = responseEntity.getBody();

        return allPolls;
    }

    public URI createPoll(Poll poll) {
        return restTemplate.postForLocation(QUICK_POLL_URI_V1, poll);
    }

    public void updatePoll(Poll poll) {
        restTemplate.put(QUICK_POLL_URI_V1 + "/{pollId}", poll, poll.getPollId());
    }

    public void deletePoll(Long pollId) {
        restTemplate.delete(QUICK_POLL_URI_V1 + "/{pollId}", pollId);
    }
}
