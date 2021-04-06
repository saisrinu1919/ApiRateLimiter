package com.techmojo.apiRateLimiter.services;

public interface IApiRateLimitService {
    public void processApiRequest(String tenantId) throws IllegalAccessException;
}

