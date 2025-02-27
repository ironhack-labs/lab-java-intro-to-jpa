CREATE SCHEMA airline;
USE airline;

CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
	customer_name VARCHAR (255),
	customer_status ENUM('GOLD', 'SILVER', 'NONE') NOT NULL,
	total_customer_mileage INT,
	PRIMARY KEY (customer_id)
);

CREATE TABLE flight (
	flight_id INT NOT NULL AUTO_INCREMENT,
	flight_number VARCHAR (255) NOT NULL UNIQUE,
	aircraft VARCHAR (255),
	total_aircraft_seats INT,
	flight_mileage INT,
	PRIMARY KEY (flight_id)
);

CREATE TABLE flight_booking (
	booking_id INT NOT NULL AUTO_INCREMENT,
	customer_id INT NOT NULL,
	flight_id INT NOT NULL,
	PRIMARY KEY (booking_id),
	FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	FOREIGN KEY (flight_id) REFERENCES flight(flight_id)
);


-- INSERTS

-- CUSTOMER

INSERT INTO customer (customer_name, customer_status, total_customer_mileage) VALUES 
('Agustine Riviera', 'SILVER', 115235),
('Alaina Sepulvida', 'NONE', 6008),
('Tom Jones', 'GOLD', 205767),
('Sam Rio', 'NONE', 2653),
('Jessica James', 'SILVER', 127656),
('Ana Janco', 'SILVER', 136773),
('Jennifer Cortez', 'GOLD', 300582),
('Christian Janco', 'SILVER', 14642);

-- FLIGHT

INSERT INTO flight (flight_number, aircraft, total_aircraft_seats, flight_mileage) VALUES
("DL143", "Boeing 747", 400, 135),
("DL122", "Airbus A330", 236, 4370),
("DL53", "Boeing 777", 264, 2078),
("DL222", "Boeing 777", 264, 1765),
("DL37", "Boeing 747", 400, 531);

-- FLIGHT_BOOKING

INSERT INTO flight_booking (customer_id, flight_id) VALUES
(1, 1),
(1, 2),
(2, 2),
(3, 2),
(3, 3),
(4, 1),
(3, 4),
(5, 1),
(6, 4),
(7, 4),
(5, 2),
(4, 5),
(8, 4);