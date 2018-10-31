package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.User;
import java.util.HashSet;
import java.util.Set;

public class RoleCommand {
    private Long id;
    private String roleName;
    private Set<User> users = new HashSet<>();

    public RoleCommand() {
    }

    public RoleCommand(Long id, String roleName, Set<User> users) {
        this.id = id;
        this.roleName = roleName;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
