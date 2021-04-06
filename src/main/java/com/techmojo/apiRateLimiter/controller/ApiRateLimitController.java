package com.techmojo.apiRateLimiter.controller;

import com.techmojo.apiRateLimiter.services.ApiRateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiRateLimitController {

    @Autowired
    private ApiRateLimitService apiRateLimitService;

    @GetMapping("/rateLimit/{tenantId}")
    public String rateLimit(@PathVariable("tenantId") String tenantId) {
        try {
            apiRateLimitService.processApiRequest(tenantId);
            return "Successful";
        } catch (IllegalAccessException e) {
            return e.getMessage();
        }
    }
}
