package com.example.demospringwebmvcapplication;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;

@Controller
public class SimpleController {

    @GetMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
