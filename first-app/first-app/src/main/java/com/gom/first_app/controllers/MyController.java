package com.gom.first_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot";
    }

    @GetMapping("/aboutus")
    public  String about() {
        return "Hello, About Us Page";
    }
}
