package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.PositionCommand;
import com.group5.interviewmanage.domain.Position;

import java.util.Set;

public interface PositionService {
    Set<Position> getPositions();
    Position findById(Long l);
    void deleteById(Long id);
    void save(Position contact);

    PositionCommand findCommandById(Long id);
    PositionCommand savePositionCommand(PositionCommand command);

    Set<Position> searchPositionByCodeOrByName(String name);
}
