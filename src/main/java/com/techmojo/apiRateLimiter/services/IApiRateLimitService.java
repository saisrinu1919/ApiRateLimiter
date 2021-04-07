package com.techmojo.apiRateLimiter.services;

public interface IApiRateLimitService {
    void processApiRequest(String tenantId) throws IllegalAccessException;
}

