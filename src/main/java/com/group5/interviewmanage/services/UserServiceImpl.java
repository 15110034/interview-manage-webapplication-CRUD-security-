package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.converters.UserCommandUser;
import com.group5.interviewmanage.converters.UserUserCommand;
import com.group5.interviewmanage.domain.Role;
import com.group5.interviewmanage.domain.User;
import com.group5.interviewmanage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

    UserRepository userRepository;
    UserUserCommand userUserCommand;
    UserCommandUser userCommandUser;

    public UserServiceImpl(UserRepository userRepository, UserUserCommand userUserCommand, UserCommandUser userCommandUser) {
        this.userRepository = userRepository;
        this.userUserCommand = userUserCommand;
        this.userCommandUser = userCommandUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByAccountFsoft(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.get().getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.get().getAccountFsoft(), user.get().getPassword(), grantedAuthorities);
    }

    @Override
    public Set<User> getUsers() {
        Set<User> userSet = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }

    @Override
    public User findById(Long l) {
        return userRepository.findOne(l);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserCommand findUserById(Long id) {
        User user = findById(id);
        return userUserCommand.convert(user);
    }

    @Override
    public UserCommand saveUserCommand(UserCommand command) {
        User detachedUser = userCommandUser.convert(command);
        User savedUser = userRepository.save(detachedUser);
        return userUserCommand.convert(savedUser);
    }


}
