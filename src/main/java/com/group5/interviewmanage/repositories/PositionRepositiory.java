package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.Position;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PositionRepositiory extends CrudRepository<Position, Long> {
    Set<Position> findPositionByCodeContains(String name);
}
