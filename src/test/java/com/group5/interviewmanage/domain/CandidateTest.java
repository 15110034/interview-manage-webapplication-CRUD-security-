package com.group5.interviewmanage.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandidateTest {
    Candidate candidate;
    @Before
    public void setUp() throws Exception {
        candidate = new Candidate();


    }

    @Test
    public void getId() {
        Long id = new Long(4l);
        candidate.setId(id);
        assertEquals(id, candidate.getId());
    }

    @Test
    public void getName() {
        String name = new String("Tran Ngoc Khoa");
        candidate.setName(name);
        assertEquals(candidate.getName(), name);


    }

    @Test
    public void setName() {
        String name = new String("Le Hoang Giang");
        candidate.setName(name);
        assertEquals(candidate.getName(), name);
    }
}