package com.samsoftware.quickpoll.client;

import com.samsoftware.quickpoll.domain.Poll;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class QuickPollClientV2 {

    private static final String QUICK_POLL_URI_2 = "http://localhost:8080/v2/polls";
    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        PageWrapper<Poll> response = new QuickPollClientV2().getAllPolls(2,2);
        response.getContent().forEach(System.out::println);
        System.out.println("First: "+response.getFirst());
        System.out.println("Last: "+response.getLast());
        System.out.println("TotalPages: "+response.getTotalPages());
        System.out.println("Number: "+response.getNumber());
        System.out.println("Size: "+response.getSize());
        System.out.println("Number of El: "+response.getNumberOfElements());
        System.out.println("Total El: "+response.getTotalElements());
    }

    public PageWrapper<Poll> getAllPolls(int page, int size) {
        ParameterizedTypeReference<PageWrapper<Poll>> responseType = new ParameterizedTypeReference<>() {
        };
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(QUICK_POLL_URI_2)
                .queryParam("page", page)
                .queryParam("size", size);

        ResponseEntity<PageWrapper<Poll>> responseEntity = restTemplate.exchange(builder.build().toUri(), HttpMethod.GET, null, responseType);

        return responseEntity.getBody();
    }
}
