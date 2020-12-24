Hibernate: create table Client (id int8 not null, email varchar(255),
                                name varchar(255), roomCount int4 not null, primary key (id))

Hibernate: create table Hotel (id int8 not null, name varchar(255),
                                stars int8, reception_id int8, primary key (id))

Hibernate: create table Reception (id int8 not null, name varchar(255), primary key (id))

Hibernate: create table Room (id int8 not null, roomCount int8,
                                client_id int8, reception_id int8, primary key (id))

Hibernate: create table Staff (id int8 not null, email varchar(255), name varchar(255),
                                reception_id int8, primary key (id))

Hibernate: alter table if exists Hotel add constraint FKgcsgr9cxgmxn019nyr8yv8491
                                        foreign key (reception_id) references Reception

Hibernate: alter table if exists Room add constraint FKnu08r9tonqc7c5cr64iw7r5de
                                        foreign key (client_id) references Client

Hibernate: alter table if exists Room add constraint FK2tkjun9bfe0srqio5g8vvcy5t
                                        foreign key (reception_id) references Reception

Hibernate: alter table if exists Staff add constraint FKddr9xn9h14pesp91jljncbq6h
                                        foreign key (reception_id) references Reception
