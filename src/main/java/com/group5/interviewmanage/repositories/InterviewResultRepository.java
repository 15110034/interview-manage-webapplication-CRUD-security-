package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.InterviewResult;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface InterviewResultRepository extends CrudRepository<InterviewResult, Long>{
    Set<InterviewResult> findInterviewResultByCandidate_NameContains(String name);
}
