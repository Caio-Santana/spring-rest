package com.samsoftware.quickpoll.v1.controller;

import com.samsoftware.quickpoll.QuickpollApplication;
import com.samsoftware.quickpoll.domain.Poll;
import com.samsoftware.quickpoll.repository.PollRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest(classes = QuickpollApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
class PollControllerTest {

    @InjectMocks
    PollController pollController;

    @Mock
    private PollRepository pollRepository;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(pollController).build();
    }

    @Test
    void testGetAllPolls() throws Exception {
        when(pollRepository.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/v1/polls"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    void getAllPolls() {
        PollController pollController = new PollController();
        ReflectionTestUtils.setField(pollController, "pollRepository", pollRepository);

        when(pollRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<Iterable<Poll>> allPollsEntity = pollController.getAllPolls();

        verify(pollRepository, times(1)).findAll();
        assertEquals(HttpStatus.OK, allPollsEntity.getStatusCode());
        assertEquals(0, Lists.newArrayList(allPollsEntity.getBody()).size());
    }
}