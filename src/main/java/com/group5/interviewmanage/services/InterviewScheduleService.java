package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.InterviewScheduleCommand;
import com.group5.interviewmanage.domain.InterviewSchedule;

import java.util.Set;

public interface InterviewScheduleService {

    Set<InterviewSchedule> getInterviewSchedules();
    InterviewSchedule findById(Long l);
    void deleteById(Long id);
    void save(InterviewSchedule contact);
    Set<InterviewSchedule> searchInterviewSchedule(String s);

    InterviewScheduleCommand findCommandById(Long id);
    InterviewScheduleCommand saveInterviewScheduleCommand(InterviewScheduleCommand command);
}
