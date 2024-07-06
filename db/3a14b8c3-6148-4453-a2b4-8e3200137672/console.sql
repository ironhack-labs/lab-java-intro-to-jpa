CREATE DATABASE hospital_db;


DROP DATABASE hospital_db;


USE hospital_db;


CREATE TABLE Employee(
                employee_id INTEGER PRIMARY KEY,
                 department TEXT,
                  name TEXT,
                   status TEXT

);


CREATE TABLE  Patient
(
    patient_id    INTEGER PRIMARY KEY,
    name          TEXT,
    date_of_birth TEXT,
    admitted_by   INTEGER,
    FOREIGN KEY (admitted_by) REFERENCES Employee (employee_id)
);


INSERT INTO Employee(employee_id, department, name, status)
VALUES
     (356712, 'cardiology', 'Alonso Flores', 'ON_CALL'),
     (564134, 'immunology', 'Sam Ortega', 'ON'),
     (761527, 'cardiology', 'German Ruiz', 'OFF'),
     (166552, 'pulmonary', 'Maria Lin', 'ON'),
     (156545, 'orthopaedic', 'Paolo Rodriguez', 'ON_CALL'),
     (172456, 'psychiatric', 'John Paul Armes', 'OFF');


INSERT INTO Patient(patient_id, name, date_of_birth, admitted_by)
VALUES
    (1, 'Jaime Jordan', '1984-03-02', 564134),
    (2, 'Marian Garcia', '1972-01-12', 564134),
    (3, 'Julia Dusterdieck', '1954-06-11', 356712),
    (4, 'Steve McDuck', '1931-11-10', 761527),
    (5, 'Marian Garcia', '1999-02-15', 172456);



SELECT *
FROM Employee;

SELECT *
FROM Employee
WHERE employee_id = 356712;

SELECT *
FROM Employee
WHERE status = 'ON';

SELECT *
FROM Employee
WHERE department = 'cardiology';

SELECT *
FROM Patient;

SELECT *
FROM Patient
WHERE patient_id = 3;

SELECT *
FROM Patient
WHERE date_of_birth
BETWEEN 1999-02-15
    AND 1931-11-10;

SELECT Patient.*
FROM Patient
JOIN Employee
ON Patient.admitted_by = Employee.employee_id
WHERE Employee.department = 'cardiology';


SELECT Patient.*
FROM Patient
JOIN Employee
ON Patient.admitted_by = Employee.employee_id
WHERE Employee.status = 'OFF'


