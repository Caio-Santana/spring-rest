package com.samsoftware.quickpoll.repository;

import com.samsoftware.quickpoll.domain.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {
}
