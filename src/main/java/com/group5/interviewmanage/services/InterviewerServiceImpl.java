package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.InterviewerCommand;
import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.converters.InterviewerCommandInterviewer;
import com.group5.interviewmanage.converters.InterviewerInterviewerCommand;
import com.group5.interviewmanage.converters.UserCommandUser;
import com.group5.interviewmanage.domain.Interviewer;
import com.group5.interviewmanage.domain.User;
import com.group5.interviewmanage.repositories.InterviewerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

@Service
public class InterviewerServiceImpl implements InterviewerService {

    InterviewerRepository interviewerRepository;
    UserService userService;
    UserCommandUser userCommandUser;
    InterviewerInterviewerCommand interviewerInterviewerCommand;
    InterviewerCommandInterviewer interviewerCommandInterviewer;

    private static final Logger logger = LoggerFactory.getLogger(InterviewerServiceImpl.class);

    @Autowired
    public InterviewerServiceImpl(InterviewerRepository interviewerRepository, UserService userService,
                                  UserCommandUser userCommandUser,
                                  InterviewerInterviewerCommand interviewerInterviewerCommand,
                                  InterviewerCommandInterviewer interviewerCommandInterviewer) {
        this.interviewerRepository = interviewerRepository;
        this.userService = userService;
        this.userCommandUser = userCommandUser;
        this.interviewerInterviewerCommand = interviewerInterviewerCommand;
        this.interviewerCommandInterviewer = interviewerCommandInterviewer;
    }

    @Override
    public Set<Interviewer> getInterviewers() {
        Set<Interviewer> interviewerSet = new HashSet<>();
        interviewerRepository.findAll().iterator().forEachRemaining(interviewerSet::add);
        return interviewerSet;
    }

    @Override
    public Interviewer findById(Long l) {
        return interviewerRepository.findOne(l);
    }

    @Override
    public void deleteById(Long id) {

            interviewerRepository.delete(id);



    }

    @Override
    public void save(Interviewer contact, UserCommand userCommand) {
        logger.info("Debug--------" + userCommand.getId());
        contact.setUser(userCommandUser.convert(userCommand));
        userService.save(userCommandUser.convert(userCommand));
        interviewerRepository.save(contact);
    }

    @Override
    public InterviewerCommand findCommandById(Long id) {
        return interviewerInterviewerCommand.convert(findById(id));
    }

    @Override
    public InterviewerCommand saveCommand(InterviewerCommand command) {
        //userService.saveUserCommand(userCommand);
        Interviewer detachedInterviewer = interviewerCommandInterviewer.convert(command);
        userService.save(detachedInterviewer.getUser());
        //detachedInterviewer.setUser(userCommandUser.convert(userService.saveUserCommand(userCommand)));
        Interviewer savedInterviewer = interviewerRepository.save(detachedInterviewer);
        return interviewerInterviewerCommand.convert(savedInterviewer);
    }

    @Override
    public Set<Interviewer> searchInterviewerByAccountFsoft(String s) {
        Set<Interviewer> interviewerSet = new HashSet<>();
        interviewerRepository.findInterviewerByUser_AccountFsoftContains(s).iterator().forEachRemaining(interviewerSet::add);
        return interviewerSet;
    }
}
