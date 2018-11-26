----- create db
CREATE DATABASE catalog
ENCODING = 'UTF8'
CONNECTION LIMIT = -1;

----- remove tables
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS address;

----- create tables
CREATE TABLE address(
  id           SERIAL PRIMARY KEY,
  index        INTEGER,
  city         VARCHAR(100),
  street       VARCHAR(100),
  house_number INTEGER
);

CREATE TABLE users(
  id         SERIAL PRIMARY KEY,
  name       VARCHAR(100),
  surname    VARCHAR(100),
  age        INTEGER,
  address_id INTEGER,
  FOREIGN KEY(address_id) REFERENCES address(id)
);

----- insert test information
INSERT INTO address(id, index, city, street, house_number) VALUES (1, 543124, 'St Peterdburg', 'Tverskaya', 39);
INSERT INTO address(id, index, city, street, house_number) VALUES (2, 166281, 'Moscow', 'Lenina', 1);

INSERT INTO users(id, name, surname, age, address_id) VALUES (1, 'Oleg', 'Ivanov', 25, 1);
INSERT INTO users(id, name, surname, age, address_id) VALUES (2, 'Kirill', 'Petrov', 18, 1);
INSERT INTO users(id, name, surname, age, address_id) VALUES (3, 'Ivan', 'Sidorov', 31, 2);
