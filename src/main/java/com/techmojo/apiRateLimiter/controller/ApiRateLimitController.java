package com.techmojo.apiRateLimiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ApiRateLimitController {
    @GetMapping("/ratelimit")
    public String greeting() {
        return "Hello";
    }
}
