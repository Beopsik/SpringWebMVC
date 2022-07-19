package com.example.demospringwebmvcapplication;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

@Controller
public class SimpleController {

    @PostMapping("events")
    @ResponseBody
    public Event getEvent(@RequestParam String name){
        Event event=new Event();
        event.setName(name);
        return event;
    }
}
