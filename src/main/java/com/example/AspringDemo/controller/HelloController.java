package com.example.AspringDemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World! Welcome to AspringDemo.";
    }

        @GetMapping("/helloJson")
    public Map<String, String> helloJson() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, World! Welcome to AspringDemo.");
        return response;
    }
}