package com.example.demospringwebmvcapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SimpleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model, HttpSession httpSession){
        Event newEvent = new Event();
        newEvent.setId(1);
        model.addAttribute("event", newEvent);
        httpSession.setAttribute("event", newEvent);
        return "events/form";
    }

    @PostMapping("events")
    public String getEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult, SessionStatus sessionStatus){
        if(bindingResult.hasErrors()){
            return "/events/form";
        }
        sessionStatus.setComplete();
        
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model){
        Event event = new Event();
        event.setName("beobsik");


        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);

        return "/events/list";
    }
}
