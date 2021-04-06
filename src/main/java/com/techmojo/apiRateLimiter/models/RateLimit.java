package com.techmojo.apiRateLimiter.models;

public class RateLimit {
    private String tenantId;
    private long milliseconds;
    private Integer count;

    public RateLimit(String tenantId, long milliseconds, Integer count) {
        this.tenantId = tenantId;
        this.milliseconds = milliseconds;
        this.count = count;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
