package com.techmojo.apiRateLimiter.repository;
import com.techmojo.apiRateLimiter.models.RequestLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRequestLogRepository extends JpaRepository<RequestLog, Long> {

    /***
     * This query returns the number of request made by the tenant from current time stamp to last hour time stamp
     * @param tenantId
     * @param currentTs ->  it stores current time stamp of the tenant request
     * @param lastHourTs -> it stores the one hour less from current time stamp (currentTs - 60 * 60 * 1000)
     * @return int
     */

    @Query("SELECT count(r.id) FROM RequestLog r WHERE r.tenantId = ?1 and r.timeStamp <= ?2 and r.timeStamp >= ?3")
    int getLastHourRequestCount(String tenantId, long currentTs, long lastHourTs);

}
