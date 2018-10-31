package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.domain.User;

import java.util.Set;

public interface UserService {
    Set<User> getUsers();
    User findById(Long l);
    void deleteById(Long id);
    void save(User user);

    UserCommand findUserById(Long id);
    UserCommand saveUserCommand(UserCommand command);
}
