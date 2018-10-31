package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.InterviewResult;
import com.group5.interviewmanage.domain.User;
import org.hibernate.validator.constraints.Email;

import java.util.HashSet;
import java.util.Set;

public class InterviewerCommand {
    private Long id;
    @Email(message = "{fooCommand.textField.email.message}")
    private String email;
    private User user;
    private Set<InterviewResult> interviewResults = new HashSet<>();



    public InterviewerCommand() {
    }

    public InterviewerCommand(Long id, String email, User user, Set<InterviewResult> interviewResults) {
        this.id = id;
        this.email = email;
        this.user = user;
        this.interviewResults = interviewResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<InterviewResult> getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(Set<InterviewResult> interviewResults) {
        this.interviewResults = interviewResults;
    }
}
