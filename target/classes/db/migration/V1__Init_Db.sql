create sequence hibernate_sequence start 1 increment 1;

create table bank_card (
    id int8 not null,
    createddate timestamp,
    is_deleted boolean not null,
    updated_date timestamp,
    pin varchar(255),
    card_numder varchar(255),
    card_user varchar(255),
    cash int4,
    is_blocked boolean not null,
    usage_time date,
    primary key (id)
);

create table card_user (
    id int8 not null,
    createddate timestamp,
    is_deleted boolean not null,
    updated_date timestamp,
    user_name varchar(255),
    description varchar(255),
    primary key (id)
);