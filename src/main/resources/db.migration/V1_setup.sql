

CREATE TABLE RequestLog
(
    id            VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    tenant_id     VARCHAR(100),
    time_stamp    DOUBLE
);




