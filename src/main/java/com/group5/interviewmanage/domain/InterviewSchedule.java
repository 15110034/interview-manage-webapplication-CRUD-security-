package com.group5.interviewmanage.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class InterviewSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int round;
    private java.sql.Date startDay;
    @ManyToOne
    @JoinColumn(name = "interviewer_id")
    private Interviewer interviewer;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public InterviewSchedule() {
    }

    public InterviewSchedule(int round, Date startDay,
                             Interviewer interviewer,
                             Candidate candidate,
                             Position position) {
        this.round = round;
        this.startDay = startDay;
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

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
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
