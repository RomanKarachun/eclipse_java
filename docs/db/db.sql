CREATE TABLE client (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	name varchar NOT NULL
);

CREATE TABLE ord (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	client_id integer NOT NULL REFERENCES client(id),
	car_id integer NOT NULL,
	price integer NOT NULL,
	distance integer NOT NULL,
	order_time datetime NOT NULL,
	arrival_time datetime NOT NULL,
	order_finish datetime NOT NULL
);

CREATE TABLE car (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT
	number_id integer NOT NULL REFERENCES ord(car_id),
	owner_id integer NOT NULL REFERENCES driver(id),
	comfort_level varchar NOT NULL,
	number_of_seats integer NOT NULL,
	free integer NOT NULL
);

CREATE TABLE driver (
	id integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	driver_name varchar NOT NULL,
	car varchar NOT NULL,
	phone_number varchar NOT NULL
);