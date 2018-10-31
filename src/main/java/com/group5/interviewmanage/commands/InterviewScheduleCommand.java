package com.group5.interviewmanage.commands;

import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.domain.InterviewResult;
import com.group5.interviewmanage.domain.Interviewer;
import com.group5.interviewmanage.domain.Position;

import java.sql.Date;

public class InterviewScheduleCommand {
    private Long id;
    private int round;
    private java.sql.Date startDay;
    private Interviewer interviewer;
    private Candidate candidate;
    private Position position;

    public InterviewScheduleCommand() {
    }

    public InterviewScheduleCommand(Long id, int round, Date startDay,
                                    Interviewer interviewer,
                                    Candidate candidate,
                                    Position position) {
        this.id = id;
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
