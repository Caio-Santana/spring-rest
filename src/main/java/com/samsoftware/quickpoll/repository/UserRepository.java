package com.samsoftware.quickpoll.repository;

import com.samsoftware.quickpoll.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
