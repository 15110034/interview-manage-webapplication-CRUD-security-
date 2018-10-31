package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.InterviewScheduleCommand;
import com.group5.interviewmanage.domain.InterviewSchedule;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterviewScheduleCommandInterviewSchedule implements Converter<InterviewScheduleCommand, InterviewSchedule> {
    @Override
    public InterviewSchedule convert(InterviewScheduleCommand interviewScheduleCommand) {
        if(interviewScheduleCommand == null) return null;

        InterviewSchedule interviewSchedule= new InterviewSchedule();
        interviewSchedule.setId(interviewScheduleCommand.getId());
        interviewSchedule.setCandidate(interviewScheduleCommand.getCandidate());
        interviewSchedule.setInterviewer(interviewScheduleCommand.getInterviewer());
        interviewSchedule.setPosition(interviewScheduleCommand.getPosition());
        interviewSchedule.setRound(interviewScheduleCommand.getRound());
        interviewSchedule.setStartDay(interviewScheduleCommand.getStartDay());

        return interviewSchedule;
    }
}
