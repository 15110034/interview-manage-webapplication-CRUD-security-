package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.InterviewScheduleCommand;
import com.group5.interviewmanage.converters.InterviewScheduleCommandInterviewSchedule;
import com.group5.interviewmanage.converters.InterviewScheduleInterviewScheduleCommand;
import com.group5.interviewmanage.domain.InterviewSchedule;
import com.group5.interviewmanage.repositories.InterviewScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class InterviewScheduleServiceImpl implements InterviewScheduleService {

    InterviewScheduleRepository interviewScheduleRepository;
    InterviewScheduleInterviewScheduleCommand interviewScheduleInterviewScheduleCommand;
    InterviewScheduleCommandInterviewSchedule interviewScheduleCommandInterviewSchedule;
    InterviewResultService interviewResultService;

    public InterviewScheduleServiceImpl(InterviewScheduleRepository interviewScheduleRepository,
                                        InterviewScheduleCommandInterviewSchedule interviewScheduleCommandInterviewSchedule,
                                        InterviewScheduleInterviewScheduleCommand interviewScheduleInterviewScheduleCommand,
                                        InterviewResultService interviewResultService) {
        this.interviewScheduleRepository = interviewScheduleRepository;
        this.interviewScheduleCommandInterviewSchedule = interviewScheduleCommandInterviewSchedule;
        this.interviewScheduleInterviewScheduleCommand = interviewScheduleInterviewScheduleCommand;
        this.interviewResultService = interviewResultService;
    }

    @Override
    public Set<InterviewSchedule> getInterviewSchedules() {
        Set<InterviewSchedule> interviewSchedules = new HashSet<>();
        interviewScheduleRepository.findAll().iterator().forEachRemaining(interviewSchedules::add);
        return interviewSchedules;
    }

    @Override
    public InterviewSchedule findById(Long l) {
        return interviewScheduleRepository.findOne(l);
    }

    @Override
    public void deleteById(Long id) {
        interviewScheduleRepository.delete(id);
    }

    @Override
    public void save(InterviewSchedule contact) {
        interviewScheduleRepository.save(contact);
    }

    @Override
    public InterviewScheduleCommand findCommandById(Long id) {
        return interviewScheduleInterviewScheduleCommand.convert(
                interviewScheduleRepository.findOne(id)
        );
    }

    @Override
    public InterviewScheduleCommand saveInterviewScheduleCommand(InterviewScheduleCommand command) {
        InterviewSchedule detachedInterviewSchedule = interviewScheduleCommandInterviewSchedule.convert(command);


        InterviewSchedule savedInterviewSchedule = interviewScheduleRepository.save(detachedInterviewSchedule);
        return interviewScheduleInterviewScheduleCommand.convert(savedInterviewSchedule);
    }

    @Override
    public Set<InterviewSchedule> searchInterviewSchedule(String s) {
        Set<InterviewSchedule> interviewSchedules = new HashSet<>();
        interviewScheduleRepository.findInterviewScheduleByCandidate_NameContains(s).iterator().forEachRemaining(interviewSchedules::add);
        return interviewSchedules;
    }
}
