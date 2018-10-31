package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.InterviewSchedule;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface InterviewScheduleRepository extends CrudRepository<InterviewSchedule, Long> {
    Set<InterviewSchedule> findInterviewScheduleByCandidate_NameContains(String s);
}
