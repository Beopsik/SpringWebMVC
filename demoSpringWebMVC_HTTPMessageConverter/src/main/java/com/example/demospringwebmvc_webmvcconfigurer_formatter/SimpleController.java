package com.example.demospringwebmvc_webmvcconfigurer_formatter;

import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    // preHandle1
    // preHandle2
    // 요청 처리
    // postHandler2
    // postHandler1
    // 뷰 렌더링
    // afterCompletion2
    // afterCompletion1

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public String message(@RequestBody String body){
        return body;
    }
}
