package com.techmojo.apiRateLimiter.controller;
import com.techmojo.apiRateLimiter.services.IApiRateLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRateLimitController {

    @Autowired
    private IApiRateLimitService apiRateLimitService;

    /***
     * Each tenant can access this api for 10 times in a hour,
     * If any tenant exceeds the threshold limit in a last current  window hour then he should wait for a time
     * until the current window hour has number of requests less than threshold defined.
     * @param tenantId -> It is id of tenant
     * @return String -> returns success or failure
     */
    @GetMapping("/rateLimit/{tenantId}")
    public String rateLimit(@PathVariable("tenantId") String tenantId) {
        try {
            apiRateLimitService.processApiRequest(tenantId);
            return "Successful";
        } catch (IllegalAccessException e) {
            return "Api rate limit threshold reached try after some time";
        }
    }
}
