package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.domain.InterviewSchedule;
import com.group5.interviewmanage.domain.Interviewer;
import com.group5.interviewmanage.domain.Position;

import java.sql.Timestamp;

public class InterviewResultCommand {
    private Long id;
    private java.sql.Timestamp start;
    private java.sql.Timestamp end;
    private boolean result;
    private Interviewer interviewer;
    private Candidate candidate;
    private Position position;

    public InterviewResultCommand() {
    }

    public InterviewResultCommand(Long id, Timestamp start, Timestamp end,
                                  boolean result, Interviewer interviewer,
                                  Candidate candidate, Position position) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.result = result;
        this.interviewer = interviewer;
        this.candidate = candidate;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
