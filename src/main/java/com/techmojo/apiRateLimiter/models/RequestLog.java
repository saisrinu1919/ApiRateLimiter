package com.techmojo.apiRateLimiter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestLog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) long id;

    private String tenantId;
    private long timeStamp;

    public RequestLog(String tenantId, long timeStamp) {
        this.tenantId = tenantId;
        this.timeStamp = timeStamp;
    }

    public RequestLog() {

    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
