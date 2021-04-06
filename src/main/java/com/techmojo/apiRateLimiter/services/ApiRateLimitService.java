package com.techmojo.apiRateLimiter.services;

import com.techmojo.apiRateLimiter.models.RequestLog;
import com.techmojo.apiRateLimiter.repository.IRequestLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApiRateLimitService implements IApiRateLimitService {

    @Autowired
    private IRequestLogRepository rateLimitRepository;

    @Value("${ratelimitthreshold}")
    private Integer rateLimitThreshold;

    public void processApiRequest(String tenantId) throws IllegalAccessException {
        long currentTimeStamp = new Date().getTime();
        int lastHourApiRequests = getTheLastHourApiRequests(tenantId, currentTimeStamp);
        if (lastHourApiRequests < rateLimitThreshold) {
            rateLimitRepository.save(new RequestLog(tenantId, currentTimeStamp));
            return;
        }
        throw new IllegalAccessException("Api rate limit threshold reached try after some time");
    }

    private int getTheLastHourApiRequests(String tenantId, long currentTimeStamp) {
        long lastHourTimeStamp = currentTimeStamp -  60 * 60 * 1000;
        return rateLimitRepository.getLastHourRequestCount(tenantId, currentTimeStamp, lastHourTimeStamp);
    }

}
