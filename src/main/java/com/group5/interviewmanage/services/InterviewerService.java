package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.InterviewerCommand;
import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.domain.Interviewer;
import com.group5.interviewmanage.domain.User;

import java.util.Set;

public interface InterviewerService {

    Set<Interviewer> getInterviewers();
    Interviewer findById(Long l);
    void deleteById(Long id);
    void save(Interviewer interviewer, UserCommand userCommand);

    InterviewerCommand findCommandById(Long id);
    InterviewerCommand saveCommand(InterviewerCommand command);
    Set<Interviewer> searchInterviewerByAccountFsoft(String s);

}
