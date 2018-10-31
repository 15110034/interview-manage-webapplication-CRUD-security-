package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.PositionCommand;
import com.group5.interviewmanage.domain.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionCommandPosition implements Converter<PositionCommand, Position> {
    @Override
    public Position convert(PositionCommand positionCommand) {
        if(positionCommand == null) return  null;

        Position position = new Position();
        position.setId(positionCommand.getId());
        position.setCode(positionCommand.getCode());
        position.setName(positionCommand.getName());
        position.setCandidates(positionCommand.getCandidates());
        position.setInterviewResults(positionCommand.getInterviewResults());

        return position;
    }
}
