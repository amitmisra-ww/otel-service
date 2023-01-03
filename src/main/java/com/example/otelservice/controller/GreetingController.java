package com.example.otelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.otelservice.service.GreetingService;

import io.opentelemetry.extension.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;

@RestController("/")
@Slf4j
public class GreetingController {
    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    @ResponseBody
    @WithSpan
    public String greet(@RequestParam("name") String name) {
        log.info("Greet Controller invoked");
        return greetingService.greet(name);
    }
}
