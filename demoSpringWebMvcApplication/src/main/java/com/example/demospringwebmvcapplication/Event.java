package com.example.demospringwebmvcapplication;

import javax.validation.constraints.NotBlank;

public class Event {

    interface ValidatedName {}

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
