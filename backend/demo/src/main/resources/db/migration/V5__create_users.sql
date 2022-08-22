create table users
(
    id          bigserial not null
        primary key,
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255),
    password    varchar(255),
    role        varchar(255),
    status varchar(255),
    username    varchar(255)
);