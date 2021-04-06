package com.techmojo.apiRateLimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ApiRateLimitApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiRateLimitApplication.class, args);
    }
}