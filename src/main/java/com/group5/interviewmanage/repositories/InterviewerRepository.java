package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.Interviewer;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface InterviewerRepository extends CrudRepository<Interviewer, Long>{
    Set<Interviewer> findInterviewerByUser_AccountFsoftContains(String s);

}
