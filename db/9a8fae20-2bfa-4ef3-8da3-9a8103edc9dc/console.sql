CREATE DATABASE my_social_network;
CREATE DATABASE my_robot_census;
CREATE  DATABASE alphabet;

USE my_social_network;

CREATE TABLE  user (
    id INTEGER PRIMARY KEY,
    name VARCHAR(50)
);

SELECT * FROM user;
INSERT INTO user(ID, name) VALUES (2, 'Henry');

SELECT name,id FROM user;

# THIS IS A COMMENT

CREATE TABLE post(
    post_id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    body VARCHAR(140),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    author INTEGER NOT NULL,
    FOREIGN KEY (author) REFERENCES user (id)
);

INSERT INTO post(title, body, author)
VALUES ('first Post', 'This is my First post', 2),
       ('Second Post', 'This is my Second post', 2),
       ('Third Post', 'This is my Third post', 2),
       ('Hello world', 'Once upon a time.....', 1);

SELECT * FROM post;


INSERT INTO user(ID, name)
VALUES (0, 'Goju');


INSERT INTO post(title, body, author)
VALUES ('Feel they infinite',null, 0);


UPDATE post SET body = 'Hello from IronHack' WHERE post_id = 4;

