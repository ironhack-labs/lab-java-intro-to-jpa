CREATE DATABASE branches_db;
USE branches_db;

CREATE TABLE Branches
(
    id INT PRIMARY KEY,
    branch_name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL
);

CREATE TABLE Accounts (
                  account_number INT PRIMARY KEY,
                  branch_id INT,
                  account_type VARCHAR(50),
                  balance DECIMAL(10, 2),
                  customer_name VARCHAR(255),
                   FOREIGN KEY (branch_id) REFERENCES Branches(id)
);

INSERT INTO Branches (id, branch_name, city) VALUES
                           (1, 'Madrid Central', 'Madrid'),
                           (2, 'Madrid Este', 'Madrid'),
                           (3, 'Toledo Central', 'Toledo');

INSERT INTO Accounts (account_number, branch_id, account_type, balance, customer_name) VALUES
                            (98273, 1, 'checking', 2319.34, 'Timothy Fusterfieck'),
                            (98274, 1, 'checking', 186.72, 'Kelsey Gordon'),
                            (98276, 2, 'checking', 7.42, 'Alvaro Rojas'),
                            (98277, 3, 'checking', 1532.72, 'Michael Alcocer');

SELECT customer_name, balance
FROM Accounts;
SELECT customer_name, balance
FROM Accounts
WHERE balance IS NOT NULL;

SELECT account_type,
AVG(balance)
AS average_balance
FROM Accounts
GROUP BY account_type;


SELECT customer_name
                    AS Name,
       account_type AS Type, balance
FROM Accounts
WHERE account_type = 'checking'
  AND branch_id = 2;

SELECT a.customer_name, a.balance, b.branch_name
FROM Accounts a
         JOIN Branches b ON a.branch_id = b.id
WHERE a.account_type = 'checking';

SELECT a.customer_name, a.balance
FROM Accounts a
         JOIN Branches b ON a.branch_id = b.id
WHERE b.branch_name = 'Madrid Central';

