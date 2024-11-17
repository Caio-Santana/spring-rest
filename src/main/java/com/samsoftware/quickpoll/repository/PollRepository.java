package com.samsoftware.quickpoll.repository;

import com.samsoftware.quickpoll.domain.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {
}
