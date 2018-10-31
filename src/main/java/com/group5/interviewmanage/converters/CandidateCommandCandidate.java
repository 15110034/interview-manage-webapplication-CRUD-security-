package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.domain.Candidate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CandidateCommandCandidate implements Converter<CandidateCommand, Candidate> {


    @Override
    public Candidate convert(CandidateCommand candidateCommand) {
        if (candidateCommand == null) {
            return null;
        }
        final Candidate candidate = new Candidate();
        candidate.setId(candidateCommand.getId());
        candidate.setAddress(candidateCommand.getAddress());
        candidate.setBirthDay(candidateCommand.getBirthDay());
        candidate.setPhone(candidateCommand.getPhone());
        candidate.setEmail(candidateCommand.getEmail());
        candidate.setGpa(candidateCommand.getGpa());
        candidate.setMajor(candidateCommand.getMajor());
        candidate.setName(candidateCommand.getName());
        candidate.setUniversity(candidateCommand.getUniversity());
        candidate.setSkills(candidateCommand.getSkills());
        candidate.setPosition(candidateCommand.getPosition());
        return candidate;
    }
}
