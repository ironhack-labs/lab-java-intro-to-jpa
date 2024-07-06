CREATE DATABASE superhero_db;

USE superhero_db;

CREATE TABLE superheroes (
                          id INT PRIMARY KEY,
                           name VARCHAR(50),
                           superpower VARCHAR(100),
                           city VARCHAR(50)
);

CREATE  TABLE  missions (
                        id INT PRIMARY KEY,
                        superhero_id INT,
                        FOREIGN KEY (superhero_id)
                            REFERENCES superheroes(id),
                        mission_name VARCHAR (100),
                        start_date DATE,
                        end_date DATE

);


INSERT INTO superheroes (id, name, superpower, city)

VALUES (1, 'Superwoman', 'Super Strength', 'Metropolis'),
             (2, 'Batman', 'Wealth and Intellect', 'Gotham City'),
             (3, 'Flash', 'Super Speed', 'Central City'),
             (4, 'Black Panther', 'Superman Ability', 'Wakanda'),
             (5, 'Invisible Woman', 'Invisibility', 'Themyscira');


INSERT INTO missions (id, superhero_id, mission_name, start_date, end_date)
VALUES
       (1, 1, 'Save the City', '2023-01-01', '2023-01-10'),
       (2, 2, 'Capture the Thieves', '2023-02-05', '2023-02-25'),
       (3, 3, 'Stop the Bank Robbery', '2023-03-11', '2023-03-23'),
       (4, 4, 'Retrieve Vibranium', '2023-04-06', '2023-04-21'),
       (5, 5, 'Stealth Mission', '2023-05-01', '2023-05-30'),
       (6, 1, 'rescue the Girls', '2023-06-07', '2023-06-29'),
       (7, 2, 'Defeat the Villain', '2023-07-15', '2023-07-25'),
       (8, 3, 'destroyed the intruders', '2023-08-03', '2023-08-19'),
       (9, 4, 'Retrieve Stolen Artifacts', '2023-09-10', '2023-09-25'),
       (10, 5, 'Save Africans Uranium', '2023-10-01', '2023-10-30');

SELECT * FROM missions;

#write a query to find the superhero with the maximum number of missions.

SELECT superhero_id, count(*)FROM missions GROUP BY superhero_id ORDER BY COUNT(*) DESC LIMIT 1;

UPDATE missions SET superhero_id = 1 WHERE id = 2;

SELECT superhero_id, AVG(DATEDIFF(end_date, start_date)) AS avg_duration
FROM missions
GROUP BY superhero_id;

SELECT superhero_id, COUNT(*) AS total_missions
FROM missions
GROUP BY superhero_id;

SELECT superhero_id, AVG(DATEDIFF(end_date, start_date)) AS success_rate
FROM missions
GROUP BY superhero_id;


SELECT s.id, s.name, s.superpower, s.city, m.mission_name, m.start_date, m.end_date
FROM superheroes s
         JOIN missions m ON s.id = m.superhero_id;

SELECT s.id, s.name, COUNT(m.id) AS mission_count,
       AVG(DATEDIFF(m.end_date, m.start_date)) AS avg_duration
FROM superheroes s
         JOIN missions m ON s.id = m.superhero_id
GROUP BY s.id, s.name
ORDER BY mission_count DESC;


