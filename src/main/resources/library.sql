drop table if exists USER cascade;

CREATE TABLE IF NOT EXISTS USER (
    id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    age INTEGER
);