CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table exchange_rates
(
    uid uuid DEFAULT uuid_generate_v4 () primary key,
    sum VARCHAR(255),
    date date
);

CREATE TABLE client
(
    uid uuid DEFAULT uuid_generate_v4 () PRIMARY KEY,
    first_name VARCHAR(255)not null,
    last_name VARCHAR(255) not null,
    account_number VARCHAR(255) null,
    email VARCHAR(255) null,
    phone VARCHAR(255)
);

CREATE TABLE type_of_operation
(
    uid            uuid DEFAULT uuid_generate_v4 () PRIMARY KEY,
    operation_name VARCHAR(255)  not null,
    peculiarities  VARCHAR(2048) not null,
    sum            VARCHAR(255)
);

create table accounts
(
    uid uuid DEFAULT uuid_generate_v4 () primary key,
    client_uid uuid
        constraint accounts_client_uid_fk
            references client(uid),
    create_date date,
    end_date date,
    status boolean default false
);

CREATE TABLE operation
(
    uid uuid DEFAULT uuid_generate_v4 () PRIMARY KEY,
    type_of_operation_uid uuid
        constraint operation_type_of_operation_uid_fk
            references type_of_operation(uid),
    accounts_uid uuid
        constraint operations_accounts_uid_fk
            references accounts(uid),
    sum varchar (255) not null,
    currency varchar(255) not null,
    the_date date,
    limit_exceed boolean default false
);


create table limits
(
    uid uuid DEFAULT uuid_generate_v4 () primary key,
    accounts_uid uuid
        constraint limits_accounts_uid_fk
            references accounts(uid),
    type_of_operation_uid uuid
        constraint limits_type_of_operation_uid_fk
            references type_of_operation(uid),
    limits varchar(255) not null,
    date date
);
