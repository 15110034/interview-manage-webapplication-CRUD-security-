package com.group5.interviewmanage.controllers;

import com.group5.interviewmanage.commands.PositionCommand;
import com.group5.interviewmanage.domain.Position;
import com.group5.interviewmanage.services.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PositionController {

    PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping({"/position"})
    public String getListPosition(Model model)
    {
        model.addAttribute("positions", positionService.getPositions());
        return "position/list";
    }

    @GetMapping({"/position/new"})
    public String newPosition(Model model)
    {
        model.addAttribute("position", new Position());
        return "position/positionform";
    }

    @GetMapping({"/position/{id}/update"})
    public String updatePosition(Model model, @PathVariable String id)
    {
        model.addAttribute("position", positionService.findCommandById(Long.valueOf(id)));
        return "position/positionform";
    }

    @PostMapping({"/position/save"})
    public String saveOrUpdatePosition(@ModelAttribute PositionCommand positionCommand)
    {
        positionService.savePositionCommand(positionCommand);
        return "redirect:/position";
    }

    @GetMapping
    @RequestMapping("position/{id}/delete")
    public String deletePosition(@PathVariable String id){
        positionService.deleteById(Long.valueOf(id));
        return "redirect:/position/";
    }
}
