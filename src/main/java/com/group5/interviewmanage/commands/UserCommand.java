package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.Role;

import java.util.HashSet;
import java.util.Set;

public class UserCommand {
    private Long id;
    private String accountFsoft;
    private String password;
    private Set<Role> roles = new HashSet<>();

    public UserCommand() {
    }

    public UserCommand(Long id, String accountFsoft, String password, Set<Role> roles) {
        this.id = id;
        this.accountFsoft = accountFsoft;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountFsoft() {
        return accountFsoft;
    }

    public void setAccountFsoft(String accountFsoft) {
        this.accountFsoft = accountFsoft;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
