package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.InterviewerCommand;
import com.group5.interviewmanage.commands.UserCommand;
import com.group5.interviewmanage.converters.InterviewerCommandInterviewer;
import com.group5.interviewmanage.converters.InterviewerInterviewerCommand;
import com.group5.interviewmanage.domain.User;
import com.group5.interviewmanage.services.InterviewerService;
import com.group5.interviewmanage.services.RoleService;
import com.group5.interviewmanage.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InterviewerController {


    private InterviewerService interviewerService;
    UserService userService;
    RoleService roleService;
    InterviewerInterviewerCommand interviewerInterviewerCommand;
    InterviewerCommandInterviewer interviewerCommandInterviewer;

    public InterviewerController(InterviewerService interviewerService,
                                 UserService userService,
                                 InterviewerInterviewerCommand interviewerInterviewerCommand,
                                 InterviewerCommandInterviewer interviewerCommandInterviewer,
                                 RoleService roleService) {
        this.interviewerService = interviewerService;
        this.userService = userService;
        this.interviewerInterviewerCommand = interviewerInterviewerCommand;
        this.interviewerCommandInterviewer = interviewerCommandInterviewer;
        this.roleService = roleService;
    }

    @RequestMapping("/interviewer")
    public String getInterviewers(Model model)
    {
        model.addAttribute("interviewers", interviewerService.getInterviewers());
        return "interviewer/list";
    }

    @RequestMapping("/interviewer/new")
    public String newInterviewer(Model model)
    {
        InterviewerCommand interviewerCommand = new InterviewerCommand();
        interviewerCommand.setUser(new User());
        model.addAttribute("interviewer", interviewerCommand);
        return "interviewer/interviewerform";
    }

    @RequestMapping("/interviewer/{id}/show")
    public String showInterviewer(Model model, @PathVariable String id)
    {
        model.addAttribute("interviewer", interviewerService.findById(Long.valueOf(id)));
        model.addAttribute("user", interviewerService.findById(Long.valueOf(id)).getUser());
        return "interviewer/show";
    }

    @PostMapping("/interviewer/save")
    public String saveOrUpdateInterviewer(@ModelAttribute InterviewerCommand interviewerCommand)
    {

        interviewerCommand.getUser().getRoles().add(roleService.findByName("INTERVIEWER"));
        interviewerCommand.getUser().getRoles().add(roleService.findByName("USER"));
        interviewerService.saveCommand(interviewerCommand);
        return "redirect:/interviewer";
    }

    @RequestMapping("/interviewer/{id}/update")
    public String updateInterviewer(Model model, @PathVariable String id)
    {
        model.addAttribute("interviewer", interviewerService.findCommandById(Long.valueOf(id)));
        return "interviewer/interviewerform";
    }

    @RequestMapping("/interviewer/{id}/delete")
    public String deleteInterviewer(@PathVariable String id)
    {
        interviewerService.deleteById(Long.valueOf(id));
        return "redirect:/interviewer";
    }

    @RequestMapping(value = "/interviewer/search")
    public String searchInterviewer(Model model, @RequestParam("s") String s)
    {
        if (s.equals("")) {
            return "redirect:/interviewer";
        }
        model.addAttribute("interviewers", interviewerService.searchInterviewerByAccountFsoft(s));
        return "interviewer/list";
    }

}
