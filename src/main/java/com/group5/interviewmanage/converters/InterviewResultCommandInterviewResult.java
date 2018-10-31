package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.domain.InterviewResult;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class InterviewResultCommandInterviewResult implements Converter<InterviewResultCommand, InterviewResult> {
    @Override
    public InterviewResult convert(InterviewResultCommand interviewResultCommand) {
        if(interviewResultCommand == null) return null;

        InterviewResult interviewResult = new InterviewResult();
        interviewResult.setId(interviewResultCommand.getId());
        interviewResult.setCandidate(interviewResultCommand.getCandidate());
        interviewResult.setInterviewer(interviewResultCommand.getInterviewer());
        interviewResult.setPosition(interviewResultCommand.getPosition());
        interviewResult.setStart(interviewResultCommand.getStart());
        interviewResult.setEnd(interviewResultCommand.getEnd());
        interviewResult.setResult(interviewResultCommand.isResult());

        return interviewResult;
    }
}
