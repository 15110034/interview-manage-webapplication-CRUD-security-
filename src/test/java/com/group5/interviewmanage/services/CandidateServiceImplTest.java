package com.group5.interviewmanage.services;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.converters.CandidateCandidateCommand;
import com.group5.interviewmanage.converters.CandidateCommandCandidate;
import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.exceptions.NotFoundException;
import com.group5.interviewmanage.repositories.CandidateRepository;
import com.group5.interviewmanage.repositories.SkillRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class CandidateServiceImplTest {

    CandidateServiceImpl candidateService;

    @Mock
    CandidateRepository candidateRepository;
    @Mock
    CandidateCandidateCommand candidateCandidateCommand;
    @Mock
    CandidateCommandCandidate candidateCommandCandidate;
    @Mock
    SkillRepository skillRepository;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        candidateService = new CandidateServiceImpl(candidateRepository,
                candidateCandidateCommand, candidateCommandCandidate,
                skillRepository);
    }



    @Test
    public void findById() {
        Candidate candidate1 = new Candidate();
        candidate1.setId(1L);

        when(candidateRepository.findOne(anyLong())).thenReturn(candidate1);

        Candidate candidateReturned = candidateService.findById(1L);
        assertEquals(candidate1, candidateReturned);
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() throws Exception {
        when(candidateRepository.findOne(anyLong())).thenReturn(null);

        Candidate candidateReturned = candidateService.findById(1L);

        if (candidateReturned == null) {
            throw new NotFoundException("Not Found");
        }

    }


    @Test
    public void deleteById() throws Exception{
        Long idToDelete = Long.valueOf(2L);
        candidateRepository.delete(idToDelete);
        assertNull(candidateRepository.findOne(idToDelete));
    }

    @Test
    public void findCommandById() {
        Candidate candidate = new Candidate();
        candidate.setId(1L);
        when(candidateRepository.findOne(anyLong())).thenReturn(candidate);
        CandidateCommand recipeCommand = new CandidateCommand();
        recipeCommand.setId(1L);
        when(candidateCandidateCommand.convert(any())).thenReturn(recipeCommand);

        CandidateCommand commandById = candidateService.findCommandById(1L);

        assertNotNull("Null recipe returned", commandById);
        verify(candidateRepository, times(1)).findOne(anyLong());
        verify(candidateRepository, never()).findAll();
    }



}