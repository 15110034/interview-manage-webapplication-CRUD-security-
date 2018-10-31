package com.group5.interviewmanage.repositories;

import com.group5.interviewmanage.domain.Candidate;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {
    Set<Candidate> findCandidateByNameContains(String name);
}
