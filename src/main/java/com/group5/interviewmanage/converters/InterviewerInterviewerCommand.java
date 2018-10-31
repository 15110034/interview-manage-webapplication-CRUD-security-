package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.InterviewerCommand;
import com.group5.interviewmanage.domain.Interviewer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterviewerInterviewerCommand implements Converter<Interviewer, InterviewerCommand> {
    @Override
    public InterviewerCommand convert(Interviewer interviewer) {
        if(interviewer == null) return null;

        InterviewerCommand interviewerCommand = new InterviewerCommand();
        interviewerCommand.setId(interviewer.getId());
        interviewerCommand.setUser(interviewer.getUser());
        interviewerCommand.setEmail(interviewer.getEmail());
        interviewerCommand.setInterviewResults(interviewer.getInterviewResults());

        return interviewerCommand;
    }
}
