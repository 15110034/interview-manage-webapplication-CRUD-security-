package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByAccountFsoft(String accountFsoftName);
}
