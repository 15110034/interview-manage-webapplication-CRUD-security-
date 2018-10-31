package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.CandidateCommand;
import com.group5.interviewmanage.services.CandidateService;
import com.group5.interviewmanage.services.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CandidateController {
    CandidateService candidateService;
    PositionService positionService;

    public CandidateController(CandidateService candidateService, PositionService positionService) {
        this.candidateService = candidateService;
        this.positionService = positionService;
    }

    @GetMapping({"/candidate", "/"})
    public String getListCandidate(Model model)
    {
        model.addAttribute("candidates",candidateService.getCandidates());
        return "candidate/list";
    }

    @RequestMapping({"/candidate/{id}/show"})
    public String getCandidate(@PathVariable String id, Model model)
    {
        model.addAttribute("candidate",candidateService.findById(Long.valueOf(id)));
        return "candidate/show";
    }

    @RequestMapping({"/candidate/new"})
    public String newCandidate(Model model)
    {
        model.addAttribute("candidate", new CandidateCommand());
        model.addAttribute("positions", positionService.getPositions());
        return "candidate/candidateform";
    }

    @GetMapping
    @RequestMapping("candidate/{id}/update")
    public String updateCandidate(@PathVariable String id, Model model){
        model.addAttribute("candidate", candidateService.findById(Long.valueOf(id)));
        model.addAttribute("positions", positionService.getPositions());
        return  "candidate/candidateform";
    }

    @PostMapping("candidate")
    public String saveOrUpdate(@Valid @ModelAttribute CandidateCommand candidate, BindingResult result, Model model){
//        if(result.hasErrors()) {
//            System.out.println("Errror: --------------------------------");
//            model.addAttribute("candidate", candidate);
//            model.addAttribute("positions", positionService.getPositions());
//            return "candidate/candidateform";
//        }
        CandidateCommand savedCommand = candidateService.saveCandidateCommand(candidate);

        return "redirect:/candidate/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("candidate/{id}/delete")
    public String deleteCandidate(@PathVariable String id){
        candidateService.deleteById(Long.valueOf(id));
        return "redirect:/candidate/";
    }

    @RequestMapping(value = "/candidate/search")
    public String searchInterviewSchedule(Model model, @RequestParam("s") String s)
    {
        if (s.equals("")) {
            return "redirect:/candidate";
        }
        model.addAttribute("candidates", candidateService.findCandidateByName(s));
        return "candidate/list";
    }

}
