drop table if exists doctors cascade;
drop table if exists patients cascade;
drop table if exists tickets cascade;

create table if not exists doctors (
    id bigint generated always as identity primary key,
    uuid varchar not null unique,
    name varchar not null,
    surname varchar not null,
    second_name varchar not null,
    is_active bool not null,
    work_start_time timestamp without time zone not null,
    birthday timestamp without time zone not null,
    license varchar not null
);

create table if not exists patients (
    id bigint generated always as identity primary key,
    uuid varchar not null unique,
    name varchar not null,
    surname varchar not null,
    second_name varchar not null,
    is_active bool not null,
    birthday timestamp without time zone not null,
    inn varchar not null
);

create table if not exists tickets (
    id bigint generated always as identity primary key,
    doctor_id bigint not null references doctors (id) on delete cascade,
    patient_id bigint references patients (id) on delete cascade,
    start timestamp without time zone not null,
    "end" timestamp without time zone not null,
    is_free bool not null
);