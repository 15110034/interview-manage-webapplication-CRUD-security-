package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.PositionCommand;
import com.group5.interviewmanage.domain.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionPositionCommand implements Converter<Position, PositionCommand> {
    @Override
    public PositionCommand convert(Position position) {
        if(position == null) return null;

        PositionCommand positionCommand = new PositionCommand();
        positionCommand.setId(position.getId());
        positionCommand.setCode(position.getCode());
        positionCommand.setName(position.getName());
        positionCommand.setCandidates(position.getCandidates());
        positionCommand.setInterviewResults(position.getInterviewResults());

        return positionCommand;
    }
}
