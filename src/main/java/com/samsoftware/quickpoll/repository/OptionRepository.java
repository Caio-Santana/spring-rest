package com.samsoftware.quickpoll.repository;

import com.samsoftware.quickpoll.domain.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
}
