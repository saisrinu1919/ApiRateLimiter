package com.techmojo.apiRateLimiter.services;

import org.springframework.stereotype.Service;

public interface IApiRateLimitService {
    void processApiRequest(String tenantId) throws IllegalAccessException;
}

