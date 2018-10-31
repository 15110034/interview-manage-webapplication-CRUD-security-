package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.InterviewerCommand;
import com.group5.interviewmanage.domain.Interviewer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterviewerCommandInterviewer implements Converter<InterviewerCommand, Interviewer> {
    @Override
    public Interviewer convert(InterviewerCommand interviewerCommand) {
        if(interviewerCommand == null) return null;

        Interviewer interviewer = new Interviewer();
        interviewer.setId(interviewerCommand.getId());
        interviewer.setUser(interviewerCommand.getUser());
        interviewer.setEmail(interviewerCommand.getEmail());
        interviewer.setInterviewResults(interviewerCommand.getInterviewResults());

        return interviewer;
    }
}
