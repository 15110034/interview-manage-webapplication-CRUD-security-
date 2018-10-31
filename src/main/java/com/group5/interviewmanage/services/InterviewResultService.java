package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.domain.InterviewResult;

import java.util.Set;

public interface InterviewResultService {

    Set<InterviewResult> getInterviewResults();
    InterviewResult findById(Long l);
    void deleteById(Long id);
    void save(InterviewResult contact);

    InterviewResultCommand findCommandById(Long id);
    InterviewResultCommand saveInterviewResultCommand(InterviewResultCommand command);

    Set<InterviewResult> searchInterviewResultByCandidateName(String name);
}
