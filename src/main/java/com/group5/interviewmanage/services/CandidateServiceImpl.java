package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.converters.CandidateCandidateCommand;
import com.group5.interviewmanage.converters.CandidateCommandCandidate;
import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.domain.Skill;
import com.group5.interviewmanage.repositories.CandidateRepository;
import com.group5.interviewmanage.repositories.SkillRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class CandidateServiceImpl implements CandidateService {
    CandidateRepository candidateRepository;
    CandidateCandidateCommand candidateCandidateCommand;
    CandidateCommandCandidate candidateCommandCandidate;
    SkillRepository skillRepository;


    public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateCandidateCommand candidateCandidateCommand, CandidateCommandCandidate candidateCommandCandidate
    , SkillRepository skillRepository) {
        this.candidateRepository = candidateRepository;
        this.candidateCandidateCommand = candidateCandidateCommand;
        this.candidateCommandCandidate = candidateCommandCandidate;
        this.skillRepository = skillRepository;
    }

    @Override
    public Set<Candidate> getCandidates() {
        Set<Candidate> candidateSet = new HashSet<>();
        candidateRepository.findAll().iterator().forEachRemaining(candidateSet::add);
        return candidateSet;
    }

    @Override
    public Candidate findById(Long l) {
        return candidateRepository.findOne(l);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        Candidate candidate = findById(id);
        Set<Skill> skills = candidate.getSkills();
        for (Skill skill: skills
             ) {
            skill.getCandidates().remove(candidate);
            skillRepository.save(skill);
        }

        candidateRepository.delete(candidateRepository.save(candidate).getId());
    }

    @Override
    public void save(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Override
    public CandidateCommand findCommandById(Long id) {
        return candidateCandidateCommand.convert(findById(id));
    }

    @Override
    @Transactional
    public CandidateCommand saveCandidateCommand(CandidateCommand command) {
        Candidate detachedCandidate = candidateCommandCandidate.convert(command);

        Candidate savedCandidate = candidateRepository.save(detachedCandidate);
        //log.debug("Saved RecipeId:" + savedRecipe.getId());
        return candidateCandidateCommand.convert(savedCandidate);
    }

    @Override
    public Candidate addSkill(Candidate candidate, Skill skill) {
        candidate.getSkills().add(skill);
        skill.getCandidates().add(candidate);
        skillRepository.save(skill);
        return candidateRepository.save(candidate);
    }
    @Transactional
    @Override
    public Candidate removeSkill(Candidate candidate, Skill skill) {
        candidate.getSkills().remove(skill);
        skill.getCandidates().remove(candidate);
        skillRepository.save(skill);
        return candidateRepository.save(candidate);
    }

    @Override
    public Set<Candidate> findCandidateByName(String name) {
        Set<Candidate> candidateSet = new HashSet<>();
        candidateRepository.findCandidateByNameContains(name).iterator().forEachRemaining(candidateSet::add);
        return candidateSet;
    }
}
