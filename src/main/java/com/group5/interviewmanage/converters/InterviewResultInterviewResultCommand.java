package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.domain.InterviewResult;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterviewResultInterviewResultCommand implements Converter<InterviewResult, InterviewResultCommand> {
    @Override
    public InterviewResultCommand convert(InterviewResult interviewResult) {
        if(interviewResult == null) return null;
        InterviewResultCommand interviewResultCommand = new InterviewResultCommand();
        interviewResultCommand.setId(interviewResult.getId());
        interviewResultCommand.setCandidate(interviewResult.getCandidate());
        interviewResultCommand.setInterviewer(interviewResult.getInterviewer());
        interviewResultCommand.setPosition(interviewResult.getPosition());
        interviewResultCommand.setStart(interviewResult.getStart());
        interviewResultCommand.setEnd(interviewResult.getEnd());
        interviewResultCommand.setResult(interviewResult.isResult());

        return interviewResultCommand;
    }
}
