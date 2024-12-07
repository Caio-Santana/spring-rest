package com.samsoftware.quickpoll.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class QuickPollClientV3BasicAuth {

    private static final String QUICK_POLL_URI_V3 = "http://localhost:8080/v3/polls";
    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        new QuickPollClientV3BasicAuth().deletePoll(1L);
    }

    private HttpHeaders getAuthenticationHeader(String username, String password) {
        String credentials = username + ":" + password;
        byte[] base64CredentialData = Base64.getEncoder().encode(credentials.getBytes());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + new String(base64CredentialData));
        return headers;
    }

    public void deletePoll(Long pollId) {
        HttpHeaders authenticationHeaders = getAuthenticationHeader("admin","Admin");
        restTemplate.exchange(QUICK_POLL_URI_V3 + "/{pollId}", HttpMethod.DELETE, new HttpEntity<Void>(authenticationHeaders), Void.class, pollId);
    }
}
