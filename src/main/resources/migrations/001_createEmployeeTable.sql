--liquibase formatted sql
CREATE TABLE employees (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    salary DECIMAL(15,2) NOT NULL
    version BIGINT NOT NULL DEFAULT 0
)