package com.example.demospringwebmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents(){
        Event event1=Event.builder()
                .name("스프링 웹 MVC 스터디")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2022, 2, 22, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 2, 28, 9, 0))
                .build();

        Event event2=Event.builder()
                .name("스프링 데이터 JPA 스터디")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2022, 3, 1, 9, 0))
                .endDateTime(LocalDateTime.of(2022, 3, 8, 9, 0))
                .build();

        return List.of(event1, event2);
    }
}
