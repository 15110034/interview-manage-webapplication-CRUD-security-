package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.domain.Skill;

import java.util.Set;

public interface CandidateService {
    Set<Candidate> getCandidates();
    Candidate findById(Long l);
    void deleteById(Long id);
    void save(Candidate contact);

    CandidateCommand findCommandById(Long id);
    CandidateCommand saveCandidateCommand(CandidateCommand command);

    Candidate addSkill(Candidate candidate, Skill skill);

    Candidate removeSkill(Candidate candidate, Skill skill);
    Set<Candidate> findCandidateByName(String name);
}
