create table client(id serial, name varchar(255), email varchar(255), room_count smallint,
                Primary key(id));

create table reception(id serial Primary key,  name varchar(255));


create table hotel(id serial, name varchar(255), stars smallint, reception_id bigInt,
                Primary key(id),
                Foreign key(reception_id) references reception(id) on Delete Cascade);


create table staff(id serial, name varchar(255), email varchar(255), reception_id bigint,
                Primary key(id),
                Foreign key(reception_id) references reception(id) on Delete Cascade);


create table room(id serial Primary key, client_id bigInt,room_count smallint, reception_id bigint,
                Foreign key(reception_id) references receptions(id) on Delete Cascade on Update Cascade,
                Foreign key(client_id) references clients(id) on Delete Cascade on Update Cascade);


SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE table_name = 'client';  //columns of table