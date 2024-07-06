SELECT * FROM robots;

SELECT * FROM components;

SELECT * FROM maintenance_logs;

SELECT COUNT(*) FROM components;

SELECT AVG(weight) FROM robots;

SELECT MIN(price), MAX(price) FROM robots;

SELECT category, COUNT(*) FROM robots GROUP BY category;


INSERT INTO robots (id, name, category, model, price, weight, battery_capacity)
VALUES
    (6, 'RoboFriend', 'RM-100', 'Household', 999.99, 5.5, 5000);


SELECT category, AVG(price)
FROM robots
GROUP BY category
HAVING AVG(price) > 2000;


SELECT * FROM robots WHERE name LIKE 'RoboGu%';

SELECT * FROM robots WHERE price BETWEEN 1000 AND 3000;


SELECT * FROM robots WHERE name LIKE '%a_d';


SELECT *
FROM maintenance_logs
WHERE maintenance_date BETWEEN '2022-01-05' AND '2023-01-15';

SELECT  * FROM robots WHERE category = 'household' or price < 1500;

SELECT * FROM robots ORDER BY name DESC;

SELECT DISTINCT category FROM robots;

SELECT COUNT(DISTINCT category) FROM robots;

SELECT * FROM robots INNER JOIN components ON robots.id = components.robot_id;

SELECT * FROM robots LEFT JOIN components ON robots.id = components.robot_id;

SELECT * FROM robots RIGHT JOIN components ON robots.id = components.robot_id;

SELECT  robots.name, components.component_name FROM robots INNER JOIN components ON robots.id = components.robot_id;

SELECT * FROM robots WHERE price > (SELECT AVG(price) FROM robots);

SELECT name As RobotName FROM robots;

SELECT robots.name, components.component_name FROM robots
    LEFT JOIN components ON robots.id = components.robot_id;

SELECT  r.name, c.component_name
FROM robots r # I am declaring an alias for the robots table, so that i can referer to it as r and not robots.
  LEFT JOIN components c ON r.id = c.robot_id;

#write a query to find the robot with the maximum number of components.
SELECT robot_id, count(*) as number_of_components FROM components
         GROUP BY robot_id ORDER BY number_of_components DESC;


SELECT name, count(*) AS number_of_components
FROM components
     LEFT JOIN robots ON robot_id = robots.id
GROUP BY robot_id
ORDER BY number_of_components DESC LIMIT 1;



