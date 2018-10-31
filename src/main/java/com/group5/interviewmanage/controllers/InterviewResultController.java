package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.domain.InterviewResult;
import com.group5.interviewmanage.services.CandidateService;
import com.group5.interviewmanage.services.InterviewResultService;
import com.group5.interviewmanage.services.InterviewerService;
import com.group5.interviewmanage.services.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

@Controller
public class InterviewResultController {
    InterviewResultService interviewResultService;
    InterviewerService interviewerService;
    PositionService positionService;
    CandidateService candidateService;

    public InterviewResultController(InterviewResultService interviewResultService,
                                     InterviewerService interviewerService,
                                     PositionService positionService,
                                     CandidateService candidateService) {
        this.interviewResultService = interviewResultService;
        this.interviewerService = interviewerService;
        this.positionService = positionService;
        this.candidateService = candidateService;
    }

    @RequestMapping({"/interviewresult", "/interviewResult","/InterviewResult"})
    public String getListInterviewResult(Model model)
    {
        model.addAttribute("interviewresults", interviewResultService.getInterviewResults());
        return "interviewresult/list";
    }

    @RequestMapping({"/interviewresult/new", "/interviewResult/new","/InterviewResult/new"})
    public String newInterviewResult(Model model)
    {
        model.addAttribute("interviewresult", new InterviewResultCommand());
        model.addAttribute("interviewers", interviewerService.getInterviewers());
        model.addAttribute("candidates", candidateService.getCandidates());
        model.addAttribute("positions", positionService.getPositions());
        return "interviewresult/interviewresultform";
    }

    @RequestMapping({"/interviewresult/{id}/update", "/interviewResult/{id}/update","/InterviewResult/{id}/update"})
    public String updateInterviewResult(Model model, @PathVariable String id)
    {
        model.addAttribute("interviewresult", interviewResultService.findCommandById(Long.valueOf(id)));
        model.addAttribute("interviewers", interviewerService.getInterviewers());
        model.addAttribute("candidates", candidateService.getCandidates());
        model.addAttribute("positions", positionService.getPositions());
        return "interviewresult/interviewresultform";
    }

    @PostMapping({"/interviewresult/save"})
    public String saveOrUpdateInterviewResult(@ModelAttribute InterviewResultCommand interviewResultCommand)
    {
        interviewResultService.saveInterviewResultCommand(interviewResultCommand);
        return "redirect:/interviewresult";
    }

    @RequestMapping({"/interviewresult/{id}/delete"})
    public String deleteInterviewResult(Model model, @PathVariable String id)
    {

        //TODO: Handle exception here..
        try {
            interviewResultService.deleteById(Long.valueOf(id));
        }
        catch (ConstraintViolationException e)
        {
            model.addAttribute("Error", "Không thể xoá! Lỗi: " + e.getMessage());
        }

        return "redirect:/interviewresult";
    }
}
