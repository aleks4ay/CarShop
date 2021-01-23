DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS user_id_seq;
DROP SEQUENCE IF EXISTS car_id_seq;
DROP SEQUENCE IF EXISTS status_id_seq;
DROP SEQUENCE IF EXISTS order_id_seq;

CREATE SEQUENCE user_id_seq START WITH 1;
CREATE SEQUENCE car_id_seq START WITH 1;
CREATE SEQUENCE status_id_seq START WITH 1;
CREATE SEQUENCE order_id_seq START WITH 1;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('user_id_seq'),
  name             VARCHAR                 NOT NULL,
  surname          VARCHAR                 NOT NULL,
  login            VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE car (
  id          INTEGER PRIMARY KEY DEFAULT nextval('car_id_seq'),
  date_receiving   TIMESTAMP NOT NULL,
  brand            VARCHAR   NOT NULL,
  model            VARCHAR   NOT NULL,
  engine_type      VARCHAR   NOT NULL,
  engine_volume    DECIMAL   NOT NULL,
  fuel_consumption DECIMAL   NOT NULL,
  price             DECIMAL   NOT NULL,
  horse_power      INT       NOT NULL,
  cargo_space      INT       NOT NULL,
  seats            INT       NOT NULL,
  length           INT       NOT NULL,
  width            INT       NOT NULL,
  height           INT       NOT NULL,
  clearance        INT       NOT NULL
);


CREATE TABLE status (
  id           INTEGER PRIMARY KEY DEFAULT nextval('status_id_seq'),
  status_index INTEGER   NOT NULL,
  staus_time   TIMESTAMP NOT NULL
);

CREATE TABLE orders (
  id          INTEGER PRIMARY KEY DEFAULT nextval('order_id_seq'),
  amount      INT       NOT NULL,
  user_id     INTEGER   NOT NULL,
  car_id      INTEGER   NOT NULL,
  status_id   INTEGER   NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (car_id) REFERENCES car (id) ON DELETE CASCADE,
  FOREIGN KEY (status_id) REFERENCES status (id) ON DELETE CASCADE
);
