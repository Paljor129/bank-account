-- create schema if not exists kata;
drop table if exists transaction;
drop table if exists role;
drop table if exists account;
drop table if exists client;

create table account (
                         id bigserial not null,
                         account_number varchar(255),
                         balance numeric(38,2),
                         is_active boolean,
                         open_date timestamp(6),
                         client_id bigint not null,
                         primary key (id)
);

create table client (
                        id bigserial not null,
                        address varchar(500),
                        date_of_birth date,
                        email varchar(300) not null,
                        first_name varchar(255),
                        last_name varchar(255),
                        password varchar(255),
                        phone varchar(15),
                        postal_code varchar(10),
                        registration_date timestamp(6),
                        sex smallint,
                        town varchar(150),
                        primary key (id)
);

create table role (
                      id bigserial not null,
                      description TEXT,
                      label varchar(200) not null,
                      client_id bigint not null,
                      primary key (id)
);

create table transaction (
                             id bigserial not null,
                             amount numeric(38,2),
                             service_name varchar(255),
                             transaction_date timestamp(6),
                             transaction_type_code varchar(15),
                             account_id bigint not null,
                             primary key (id)
);

alter table if exists account
    add constraint FKkm8yb63h4ownvnlrbwnadntyn
    foreign key (client_id)
    references client;

alter table if exists role
    add constraint FKmac0oknah7ecbhs64fem2qhep
    foreign key (client_id)
    references client;

alter table if exists transaction
    add constraint FK6g20fcr3bhr6bihgy24rq1r1b
    foreign key (account_id)
    references account;