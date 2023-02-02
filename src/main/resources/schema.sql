create table IF NOT EXISTS Users(
    id serial primary key,
    firstname varchar(100) not null,
    lastname varchar(100),
    telephonenumber varchar(255) not null,
    password varchar(100) not null);