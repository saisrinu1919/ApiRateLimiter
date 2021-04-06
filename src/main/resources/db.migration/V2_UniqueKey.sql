CREATE UNIQUE INDEX RequestLogIdx
    ON RequestLog (tenant_id, time_stamp);
