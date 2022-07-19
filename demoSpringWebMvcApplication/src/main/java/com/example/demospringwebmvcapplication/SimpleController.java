package com.example.demospringwebmvcapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class SimpleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model){
        Event newEvent = new Event();
        newEvent.setId(1);
        model.addAttribute("event", newEvent);
        return "events/form";
    }

    @PostMapping("events")
    @ResponseBody
    public Event getEvent(@Validated(Event.ValidatedName.class) @ModelAttribute Event event){
        return event;
    }
}
