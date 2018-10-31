package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.PositionCommand;
import com.group5.interviewmanage.converters.PositionCommandPosition;
import com.group5.interviewmanage.converters.PositionPositionCommand;
import com.group5.interviewmanage.domain.Position;
import com.group5.interviewmanage.repositories.PositionRepositiory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PositionServiceImpl implements PositionService {

    PositionRepositiory positionRepositiory;
    PositionPositionCommand positionPositionCommand;
    PositionCommandPosition positionCommandPosition;

    public PositionServiceImpl(PositionRepositiory positionRepositiory,
                               PositionPositionCommand positionPositionCommand, PositionCommandPosition positionCommandPosition) {
        this.positionRepositiory = positionRepositiory;
        this.positionPositionCommand = positionPositionCommand;
        this.positionCommandPosition = positionCommandPosition;
    }

    @Override
    public Set<Position> getPositions() {
        Set<Position> positionSet = new HashSet<>();
        positionRepositiory.findAll().iterator().forEachRemaining(positionSet::add);
        return positionSet;
    }

    @Override
    public Position findById(Long l) {
        return positionRepositiory.findOne(l);
    }

    @Override
    public void deleteById(Long id) {
        positionRepositiory.delete(id);
    }

    @Override
    public void save(Position contact) {
        positionRepositiory.save(contact);
    }

    @Override
    public PositionCommand findCommandById(Long id) {
        return positionPositionCommand.convert(findById(id));
    }

    @Override
    public PositionCommand savePositionCommand(PositionCommand command) {
        Position detachedPosition = positionCommandPosition.convert(command);
        Position savedPosition = positionRepositiory.save(detachedPosition);
        return positionPositionCommand.convert(savedPosition);

    }

    @Override
    public Set<Position> searchPositionByCodeOrByName(String name) {
        Set<Position> positionSet = new HashSet<>();
        positionRepositiory.findPositionByCodeContains(name).iterator().forEachRemaining(positionSet::add);
        return positionSet;
    }
}
