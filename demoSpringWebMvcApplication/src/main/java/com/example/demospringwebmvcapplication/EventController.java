package com.example.demospringwebmvcapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class EventController {

//    @ExceptionHandler
//    public String eventErrorHandler(EventException exception, Model model) {
//        model.addAttribute("message", "event error");
//        return "error";
//    }
//    @InitBinder
//    public void initEventBinder(WebDataBinder webDataBinder) {
//        webDataBinder.setDisallowedFields("id");
//        webDataBinder.addValidators(new EventValidator());
//    }
//
//    @ModelAttribute
//    public void categories(Model model) {
//        model.addAttribute("categories", List.of("study", "seminar", "hobby", "social"));
//    }

//    @ModelAttribute("categories")
//    public List<String> categories(Model model) {
//        return List.of("study", "seminar", "hobby", "social");
//    }

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model){
        throw new EventException();
//        model.addAttribute("event", new Event());
//        return "/events/form-name";
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
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event, BindingResult bindingResult, SessionStatus sessionStatus, RedirectAttributes attributes){
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        attributes.addFlashAttribute("newEvent", event);
        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(Model model, @SessionAttribute LocalDateTime visitTime){
        System.out.println(visitTime);

        List<Event> eventList = new ArrayList<>();
        eventList.add((Event) model.getAttribute("newEvent"));
        model.addAttribute("eventList", eventList);

        return "/events/list";
    }
}
