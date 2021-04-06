package com.techmojo.apiRateLimiter.repository;
import com.techmojo.apiRateLimiter.models.RequestLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequestLogRepository extends JpaRepository<RequestLog, Long> {

    @Query("SELECT count(r.id) FROM RequestLog r WHERE r.tenantId = ?1 and r.timeStamp<=?2 and r.timeStamp>=?3")
    int getLastHourRequestCount(String tenantId, long currentTs, long lastHourTs);

}
