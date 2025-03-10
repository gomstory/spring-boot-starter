package com.gom.rest_api_mysql.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class TestController {
    @GetMapping("/")
    public String Index() {
        return "Hello, Spring Rest APIs";
    }

    @GetMapping("/json")
    public List<Objects> json() {
        return List.of();
    }
}
