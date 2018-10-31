package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
