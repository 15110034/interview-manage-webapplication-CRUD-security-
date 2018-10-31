package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.RoleCommand;
import com.group5.interviewmanage.domain.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleCommandRole implements Converter<RoleCommand, Role> {
    @Override
    public Role convert(RoleCommand roleCommand) {
        if(roleCommand == null) return null;
        Role role = new Role();
        role.setId(roleCommand.getId());
        role.setRoleName(roleCommand.getRoleName());
        role.setUsers(roleCommand.getUsers());

        return role;

    }
}
