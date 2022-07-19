package com.example.demospringwebmvcapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public Event getEvent(@ModelAttribute Event event){
        return event;
    }
}
