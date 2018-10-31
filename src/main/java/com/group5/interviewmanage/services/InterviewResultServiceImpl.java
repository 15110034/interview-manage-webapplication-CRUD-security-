package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.converters.InterviewResultCommandInterviewResult;
import com.group5.interviewmanage.converters.InterviewResultInterviewResultCommand;
import com.group5.interviewmanage.domain.InterviewResult;
import com.group5.interviewmanage.repositories.InterviewResultRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Service
public class InterviewResultServiceImpl implements InterviewResultService {

    InterviewResultRepository interviewResultRepository;
    InterviewResultInterviewResultCommand interviewResultInterviewResultCommand;
    InterviewResultCommandInterviewResult interviewResultCommandInterviewResult;

    public InterviewResultServiceImpl(InterviewResultRepository interviewResultRepository,
                                      InterviewResultInterviewResultCommand interviewResultInterviewResultCommand,
                                      InterviewResultCommandInterviewResult interviewResultCommandInterviewResult) {
        this.interviewResultRepository = interviewResultRepository;
        this.interviewResultInterviewResultCommand = interviewResultInterviewResultCommand;
        this.interviewResultCommandInterviewResult = interviewResultCommandInterviewResult;
    }

    @Override
    public Set<InterviewResult> getInterviewResults() {
        Set<InterviewResult> interviewResults = new HashSet<>();
        interviewResultRepository.findAll().iterator().forEachRemaining(interviewResults::add);
        return interviewResults;
    }

    @Override
    public InterviewResult findById(Long l) {
        return interviewResultRepository.findOne(l);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        interviewResultRepository.delete(id);
    }

    @Override
    public void save(InterviewResult contact) {
        interviewResultRepository.save(contact);
    }

    @Override
    public InterviewResultCommand findCommandById(Long id) {
        return interviewResultInterviewResultCommand.convert(findById(id));
    }

    @Override
    public InterviewResultCommand saveInterviewResultCommand(InterviewResultCommand command) {
        InterviewResult detachedInterviewResult = interviewResultCommandInterviewResult.convert(command);
        InterviewResult savedInterviewResult = interviewResultRepository.save(detachedInterviewResult);
        return interviewResultInterviewResultCommand.convert(savedInterviewResult);
    }

    @Override
    public Set<InterviewResult> searchInterviewResultByCandidateName(String name) {
        Set<InterviewResult> interviewResultSet = new HashSet<>();
        interviewResultRepository.findInterviewResultByCandidate_NameContains(name).iterator().forEachRemaining(interviewResultSet::add);
        return interviewResultSet;
    }
}
