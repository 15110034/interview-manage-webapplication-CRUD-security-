package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.RoleCommand;
import com.group5.interviewmanage.converters.RoleCommandRole;
import com.group5.interviewmanage.converters.RoleRoleCommand;
import com.group5.interviewmanage.domain.Role;
import com.group5.interviewmanage.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;
    RoleRoleCommand roleRoleCommand;
    RoleCommandRole roleCommandRole;

    public RoleServiceImpl(RoleRepository roleRepository, RoleRoleCommand roleRoleCommand, RoleCommandRole roleCommandRole) {
        this.roleRepository = roleRepository;
        this.roleRoleCommand = roleRoleCommand;
        this.roleCommandRole = roleCommandRole;
    }

    @Override
    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().iterator().forEachRemaining(roles::add);
        return roles;
    }

    @Override
    public Role findById(Long l) {
        return roleRepository.findOne(l);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByRoleName(name);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.delete(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public RoleCommand findCommandById(Long id) {
        return roleRoleCommand.convert(findById(id));
    }

    @Override
    public RoleCommand saveRoleCommand(RoleCommand command) {
        Role detachedRole = roleCommandRole.convert(command);
        Role savedRole = roleRepository.save(detachedRole);
        return roleRoleCommand.convert(savedRole);
    }
}
