package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.SkillCommand;
import com.group5.interviewmanage.converters.SkillCommandSkill;
import com.group5.interviewmanage.converters.SkillSkillCommand;
import com.group5.interviewmanage.domain.Skill;
import com.group5.interviewmanage.repositories.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class SkillServiceImpl implements SkillService{
    SkillRepository skillRepository;
    SkillSkillCommand skillSkillCommand;
    SkillCommandSkill skillCommandSkill;

    public SkillServiceImpl(SkillRepository skillRepository, SkillCommandSkill skillCommandSkill, SkillSkillCommand skillSkillCommand) {
        this.skillRepository = skillRepository;
        this.skillCommandSkill = skillCommandSkill;
        this.skillSkillCommand = skillSkillCommand;
    }

    @Override
    public Set<Skill> getSkills() {
        Set<Skill> skills = new HashSet<>();
        skillRepository.findAll().iterator().forEachRemaining(skills::add);
        return skills;
    }

    @Override
    public Skill findById(Long l) {
        return skillRepository.findOne(l);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.delete(id);
    }

    @Override
    public void save(Skill contact) {
        skillRepository.save(contact);
    }

    @Override
    public SkillCommand findCommandById(Long id) {
        return skillSkillCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public SkillCommand saveSkillCommand(SkillCommand command) {
        Skill detachedSkill = skillCommandSkill.convert(command);
        Skill savedSkill = skillRepository.save(detachedSkill);
        return skillSkillCommand.convert(savedSkill);
    }
}
