package com.example.demospringwebmvcapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class SimpleController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model){
        model.addAttribute("event", new Event());
        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }

        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model){
        model.addAttribute("event", event);
         return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event, BindingResult bindingResult, SessionStatus sessionStatus){
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model, @SessionAttribute LocalDateTime visitTime){
        System.out.println(visitTime);
        Event event = new Event();
        event.setName("beobsik");

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList);

        return "/events/list";
    }
}
