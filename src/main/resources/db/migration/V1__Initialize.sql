create table if not exists product
(
    code   varchar(255) not null
        primary key,
    name   varchar(255) null,
    weight double       not null
);

create table if not exists warehouse
(
    code    varchar(255) not null
        primary key,
    address varchar(255) null,
    name    varchar(255) null
);

create table if not exists stock
(
    product_code   varchar(255) not null,
    quantity       bigint       null,
    warehouse_code varchar(255) not null,
    primary key (product_code, warehouse_code),
    constraint FK85k6qr8athl3tcc2rk16rlh9u
        foreign key (product_code) references product (code),
    constraint FKhrdixg1ikcx1wnjn8982avv8t
        foreign key (warehouse_code) references warehouse (code)
);

