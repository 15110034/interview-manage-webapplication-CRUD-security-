package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.domain.InterviewResult;

import java.util.HashSet;
import java.util.Set;

public class PositionCommand {

    private Long id;
    private String code;
    private String name;
    private Set<Candidate> candidates = new HashSet<>();
    private Set<InterviewResult> interviewResults = new HashSet<>();

    public PositionCommand() {
    }

    public PositionCommand(Long id, String code, String name, Set<Candidate> candidates, Set<InterviewResult> interviewResults) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.candidates = candidates;
        this.interviewResults = interviewResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(Set<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Set<InterviewResult> getInterviewResults() {
        return interviewResults;
    }

    public void setInterviewResults(Set<InterviewResult> interviewResults) {
        this.interviewResults = interviewResults;
    }
}
