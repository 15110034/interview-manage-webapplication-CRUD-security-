package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.RoleCommand;
import com.group5.interviewmanage.domain.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleRoleCommand implements Converter<Role, RoleCommand> {
    @Override
    public RoleCommand convert(Role role) {
        if(role == null) return null;
        RoleCommand roleCommand = new RoleCommand();
        roleCommand.setId(role.getId());
        roleCommand.setRoleName(role.getRoleName());
        roleCommand.setUsers(role.getUsers());

        return roleCommand;
    }
}
