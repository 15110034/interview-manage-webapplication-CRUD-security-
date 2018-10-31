package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.commands.InterviewScheduleCommand;
import com.group5.interviewmanage.services.InterviewResultService;
import com.group5.interviewmanage.services.InterviewScheduleService;
import org.hibernate.validator.constraints.ModCheck;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class InterviewScheduleControllerTest {
    @Mock
    InterviewResultCommand interviewResultCommand;

    @Mock
    InterviewScheduleCommand interviewScheduleCommand;

    @Mock
    InterviewResultService interviewResultService;

    @Mock
    InterviewScheduleService interviewScheduleService;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void saveOrUpdateInterviewSchedule() {
    }
}