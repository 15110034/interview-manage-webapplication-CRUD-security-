package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.SkillCommand;
import com.group5.interviewmanage.domain.Skill;

import java.util.Set;

public interface SkillService {

    Set<Skill> getSkills();
    Skill findById(Long l);
    void deleteById(Long id);
    void save(Skill contact);

//    CandidateCommand findCommandById(Long id);
//    public CandidateCommand saveCandidateCommand(CandidateCommand command);

    SkillCommand findCommandById(Long id);
    SkillCommand saveSkillCommand(SkillCommand command);

}
