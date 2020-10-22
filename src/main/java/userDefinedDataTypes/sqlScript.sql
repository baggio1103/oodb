create type person as (
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    gender char(1)
);

create type hotel_client as(
    client person,
    arrival_Date date;
);

create sequence client_sequence
increment 1,
start 1;

create table client_table(
 id bigInt default nextval('client_sequence'),
 client hotel_client,
 constraint hotel_client_pkey PRIMARY KEY (id)
);



insert into client_table(client) values (row (row('Chris', 'Bale', 'chris@gmail.com', 'M'), '2020-10-21'));


select * from client_table;