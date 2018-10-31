package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.RoleCommand;
import com.group5.interviewmanage.domain.Role;
import java.util.Set;

public interface RoleService {

    Set<Role> getRoles();
    Role findById(Long l);
    Role findByName(String name);
    void deleteById(Long id);
    void save(Role role);

    RoleCommand findCommandById(Long id);
    RoleCommand saveRoleCommand(RoleCommand command);
}
