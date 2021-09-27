create table users
(
    id         bigserial primary key,
    name   varchar(50),
    postal_code integer,
    date_of_birth  date
);