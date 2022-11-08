CREATE TABLE client (
	id integer PRIMARY KEY AUTOINCREMENT,
	client_name varchar NOT NULL,
	phone_number varchar NOT NULL
);

CREATE TABLE ord (
	id integer PRIMARY KEY AUTOINCREMENT,
	client_id integer NOT NULL REFERENCES client(id),
	car_id integer NOT NULL REFERENCES car(id),
	price integer NOT NULL,
	distance integer NOT NULL,
	order_time datetime NOT NULL,
	arrival_time datetime NOT NULL,
	order_finish datetime NOT NULL
);

CREATE TABLE car (
	id integer PRIMARY KEY AUTOINCREMENT,
	car_name varchar NOT NULL,
	driver_id integer NOT NULL REFERENCES driver(id),
	comfort_level varchar NOT NULL,
	number_seats integer NOT NULL,
	free boolean NOT NULL
);

CREATE TABLE driver (
	id integer PRIMARY KEY AUTOINCREMENT,
	driver_name varchar NOT NULL,
	phone_number varchar NOT NULL
);