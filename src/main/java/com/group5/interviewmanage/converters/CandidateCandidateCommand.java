package com.group5.interviewmanage.converters;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.domain.Candidate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CandidateCandidateCommand implements Converter<Candidate, CandidateCommand> {
    @Override
    public CandidateCommand convert(Candidate candidate) {
        if(candidate == null) {
            return null;
        }
        final CandidateCommand candidateCommand = new CandidateCommand();
        candidateCommand.setId(candidate.getId());
        candidateCommand.setAddress(candidate.getAddress());
        candidateCommand.setBirthDay(candidate.getBirthDay());
        candidateCommand.setEmail(candidate.getEmail());
        candidateCommand.setGpa(candidate.getGpa());
        candidateCommand.setMajor(candidate.getMajor());
        candidateCommand.setName(candidate.getName());
        candidateCommand.setUniversity(candidate.getUniversity());
        candidateCommand.setSkills(candidate.getSkills());
        candidateCommand.setPosition(candidate.getPosition());
        return candidateCommand;
    }
}
