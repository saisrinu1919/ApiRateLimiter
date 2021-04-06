package com.techmojo.apiRateLimiter.services;

import com.techmojo.apiRateLimiter.repository.RateLimitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ApiRateLimitService {

    @Autowired
    private RateLimitRepository rateLimitRepository;

    @Value("${ratelimitthreshold}")
    private Integer rateLimitThreshold;

    public void processApiRequest(String tenantId) throws IllegalAccessException {
        long currentTimeStamp = new Date().getTime();
        int lastHourApiRequests = getTheLastHourApiRequests(currentTimeStamp);
        if (lastHourApiRequests < rateLimitThreshold) {
            rateLimitRepository.addRequest(tenantId, currentTimeStamp);
            return;
        }
        throw new IllegalAccessException("Api rate limit threshold reached try after some time");
    }

    private int getTheLastHourApiRequests(long currentTimeStamp) {
        return 0;
    }

}
