package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.InterviewScheduleCommand;
import com.group5.interviewmanage.domain.InterviewSchedule;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterviewScheduleInterviewScheduleCommand implements Converter<InterviewSchedule, InterviewScheduleCommand> {
    @Override
    public InterviewScheduleCommand convert(InterviewSchedule interviewSchedule) {
        if(interviewSchedule == null) return null;

        InterviewScheduleCommand interviewScheduleCommand = new InterviewScheduleCommand();
        interviewScheduleCommand.setId(interviewSchedule.getId());
        interviewScheduleCommand.setCandidate(interviewSchedule.getCandidate());
        interviewScheduleCommand.setInterviewer(interviewSchedule.getInterviewer());
        interviewScheduleCommand.setPosition(interviewSchedule.getPosition());
        interviewScheduleCommand.setRound(interviewSchedule.getRound());
        interviewScheduleCommand.setStartDay(interviewSchedule.getStartDay());

        return interviewScheduleCommand;
    }
}
