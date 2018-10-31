package com.group5.interviewmanage.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class InterviewResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.sql.Timestamp start;
    private java.sql.Timestamp end;
    private boolean result;
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewer_id" )
    private Interviewer interviewer;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;


    public InterviewResult() {
    }

    public InterviewResult(Timestamp start, Timestamp end, boolean result, Interviewer interviewer, Candidate candidate, Position position) {
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
