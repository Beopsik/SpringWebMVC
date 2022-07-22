package com.example.demospringwebmvcapplication;

import org.springframework.http.HttpEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event createEvent(@RequestBody @Valid Event event, BindingResult bindingResult){
        // save event
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError ->{
                System.out.println(objectError);
            });
        }
        return event;
    }
}