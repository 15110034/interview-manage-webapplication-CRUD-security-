package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.commands.SkillCommand;
import com.group5.interviewmanage.converters.CandidateCandidateCommand;
import com.group5.interviewmanage.domain.Candidate;
import com.group5.interviewmanage.domain.Skill;
import com.group5.interviewmanage.services.CandidateService;
import com.group5.interviewmanage.services.SkillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillController {

    SkillService skillService;
    CandidateService candidateService;
    CandidateCandidateCommand candidateCandidateCommand;

    public SkillController(SkillService skillService, CandidateService candidateService, CandidateCandidateCommand candidateCandidateCommand) {
        this.skillService = skillService;
        this.candidateService = candidateService;
        this.candidateCandidateCommand = candidateCandidateCommand;
    }

    @RequestMapping({"/candidate/{id}/skill"})
    public String newSkill(@PathVariable String id,  Model model)
    {
        model.addAttribute("candidate", candidateService.findCommandById(Long.valueOf(id)));
        model.addAttribute("skills", skillService.getSkills());
        return "skill/form";
    }

    @RequestMapping({"/skill"})
    public String getSkill(Model model)
    {
        model.addAttribute("skills", skillService.getSkills());
        return "skill/list";
    }

    @RequestMapping({"/skill/new"})
    public String createSkill(Model model)
    {
        model.addAttribute("skill", new SkillCommand());
        return "skill/create";
    }

    @RequestMapping({"/skill/{id}/update"})
    public String updateSkill(Model model, @PathVariable String id)
    {
        model.addAttribute("skill", skillService.findCommandById(Long.valueOf(id)));
        return "skill/create";
    }

    @RequestMapping({"/skill/save"})
    public String saveOrUpdateSkill(Model model, @ModelAttribute SkillCommand skillCommand)
    {
        skillService.saveSkillCommand(skillCommand);
        return "redirect:/skill";
    }


    @PostMapping({"/candidate/{id}/skill"})
    public String SaveorUpdateSkill(@ModelAttribute CandidateCommand candidate, @RequestParam String skillId)
    {
        candidateService.addSkill(candidateService.findById(candidate.getId()), skillService.findById(Long.valueOf(skillId)));
        return "redirect:/candidate/{id}/show";
    }

    @GetMapping({"/candidate/{id}/skill/{skillId}/delete"})
    public String deleteSkillOfCandidate(@PathVariable String id, @PathVariable String skillId)
    {
        Candidate candidate = candidateService.findById(Long.valueOf(id));
        Skill skill = skillService.findById(Long.valueOf(skillId));
        candidateService.removeSkill(candidate, skill);
        return "redirect:/candidate/{id}/show";
    }
}
