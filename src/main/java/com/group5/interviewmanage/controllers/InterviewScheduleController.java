package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.InterviewResultCommand;
import com.group5.interviewmanage.commands.InterviewScheduleCommand;
import com.group5.interviewmanage.domain.InterviewResult;
import com.group5.interviewmanage.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InterviewScheduleController {

    InterviewScheduleService interviewScheduleService;
    InterviewResultService interviewResultService;
    PositionService positionService;
    InterviewerService interviewerService;
    CandidateService candidateService;

    public InterviewScheduleController(InterviewScheduleService interviewScheduleService,
                                       InterviewResultService interviewResultService,
                                       PositionService positionService,
                                       InterviewerService interviewerService,
                                       CandidateService candidateService) {
        this.interviewScheduleService = interviewScheduleService;
        this.interviewResultService = interviewResultService;
        this.positionService = positionService;
        this.interviewerService = interviewerService;
        this.candidateService = candidateService;
    }

    @RequestMapping("/interviewschedule")
    public String getInterviewSchedules(Model model)
    {
        model.addAttribute("interviewschedules", interviewScheduleService.getInterviewSchedules());
        return "interviewschedule/list";
    }

    @RequestMapping("/interviewschedule/new")
    public String newInterviewSchedule(Model model)
    {
        model.addAttribute("interviewschedule", new InterviewScheduleCommand());
        model.addAttribute("positions", positionService.getPositions());
        model.addAttribute("interviewers", interviewerService.getInterviewers());
        model.addAttribute("candidates", candidateService.getCandidates());
        return "interviewschedule/interviewscheduleform";
    }

    @RequestMapping("/interviewschedule/{id}/show")
    public String showInterviewSchedule(Model model, @PathVariable String id)
    {
        model.addAttribute("interviewschedule", interviewScheduleService.findById(Long.valueOf(id)));
        return "interviewschedule/show";
    }

    @RequestMapping("/interviewschedule/{id}/update")
    public String updateInterviewSchedule(Model model, @PathVariable String id)
    {
        model.addAttribute("interviewschedule", interviewScheduleService.findById(Long.valueOf(id)));
        model.addAttribute("positions", positionService.getPositions());
        model.addAttribute("interviewers", interviewerService.getInterviewers());
        model.addAttribute("candidates", candidateService.getCandidates());
        return "interviewschedule/interviewscheduleform";
    }

    @RequestMapping("/interviewschedule/{id}/delete")
    public String deleteInterviewSchedule(Model model, @PathVariable String id)
    {
        interviewScheduleService.deleteById(Long.valueOf(id));
        return "redirect:/interviewschedule";
    }

    @RequestMapping(value = "/interviewschedule/save", method = RequestMethod.POST)
    public String saveOrUpdateInterviewSchedule(Model model, @ModelAttribute InterviewScheduleCommand interviewScheduleCommand)
    {
        InterviewResultCommand interviewResultCommand = new InterviewResultCommand();
        interviewResultCommand.setCandidate(interviewScheduleCommand.getCandidate());
        interviewResultCommand.setPosition(interviewScheduleCommand.getPosition());
        interviewResultCommand.setInterviewer(interviewScheduleCommand.getInterviewer());
        interviewResultService.saveInterviewResultCommand(interviewResultCommand);
        interviewScheduleService.saveInterviewScheduleCommand(interviewScheduleCommand);
        return "redirect:/interviewschedule";
    }

    @RequestMapping(value = "/interviewschedule/search")
    public String searchInterviewSchedule(Model model, @RequestParam("s") String s)
    {
        if (s.equals("")) {
            return "redirect:/interviewschedule";
        }
        model.addAttribute("interviewschedules", interviewScheduleService.searchInterviewSchedule(s));
        return "interviewschedule/list";
    }

}
