CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS account
(
    phone         varchar(300) PRIMARY KEY,
    account       varchar(300) ,
    address       varchar(300)
);

CREATE TABLE IF NOT EXISTS History
(
    uid_atc         bigint PRIMARY KEY,
    type            varchar(1000) ,
    client          varchar(1000) ,
    account         varchar(1000) ,
    via             varchar(1000) ,
    start           date         ,
    wait             varchar(1000) ,
    duration            varchar(1000) ,
    record             varchar(1000)
);

