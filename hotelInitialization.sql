create type person as(
    firstName varchar(255),
    lastName varchar(255),
    email varchar(255),
    phoneNumber char(25)    
)

create type client as(
    self person,
    cash Decimal(10,2),  
    roomCountWanted smallInt
)

create type staff as(
    self person
)

create type room as(
    room_number smallInt,
    cost numeric(7,2)
    room_count smallInt,
    client client,
    isReserved boolean
)

create type reception as(
    clients client[],
    rooms room[],
    staffMember staff
)

create type hotel as(
    name varchar(255),
    stars smallInt,
    receptionist reception
);


create table clients(id serial primary key, client client);

insert into clients(client) values(row(row('Chris', 'Bale','chris@gmail.com', '9869334644' ), '1250', 3));


create table rooms(id, room room);


insert into rooms(room) values
            (row(111, 150, 2), null, false),
            (row(222, 200, 2, null, false)),
			(row(333, 250, 3, null, false)),
			(row(444, 350, 4, null, false)),
			(row(555, 450, 5, null, false));
			


create table staff_table(id serial primary key, staff staff);

insert into staff_table(staff) values
 		(row( row('Mia', 'Anders', 'mia@gmail.com', '4623108')) );


create table reception_table(id serial primary key, receptionist reception);

insert into reception_table(receptionist)
 			values ( row( 
			Array[ cast (row( row('Chris', 'Bale','chris@gmail.com', '9869334644'), 1250, 3) as client) ],
		     Array[
	         cast (row(111, 150, 2, null, false) as room) ,
             cast (row(222, 200, 2, null, false) as room) ,
			 cast (row(333, 250, 3, null, false) as room) ,
			 cast (row(444, 350, 4, null, false) as room) ,
			 cast (row(555, 450, 5, null, false) as room)] , 						 

		  	 row( row('Tony', 'Stark', '+79869334644', 'stark@mail.com') ) ) );




create table hotels(id serial Primary key, hotel hotel);

insert into hotels(hotel) values(
	row( 'MGM-GRAND', 5, row( 
			 Array[ cast (row( row('Chris', 'Bale','chris@gmail.com', '9869334644'), 1250, 3) as client) ],
		     Array[
	         cast (row(111, 150, 2, null, false) as room) ,
             cast (row(222, 200, 2, null, false) as room) ,
			 cast (row(333, 250, 3, null, false) as room) ,
			 cast (row(444, 350, 4, null, false) as room) ,
			 cast (row(555, 450, 5, null, false) as room)] , 						 
		  	 row( row('Tony', 'Stark', '+79869334644', 'stark@mail.com')))));


select (hotel).receptionist.staffMember.self.phoneNumber from hotels;
