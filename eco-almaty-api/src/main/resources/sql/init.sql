-- #################### DATABASE INIT ####################

DROP DATABASE IF EXISTS eco_almaty;
CREATE DATABASE eco_almaty;
USE eco_almaty;

-- #################### TABLES ####################

CREATE TABLE t_countries
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(100)          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_cities
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    name       VARCHAR(100)          NOT NULL,
    country_id BIGINT                NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_users
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    username   VARCHAR(150)          NOT NULL,
    email      VARCHAR(150)          NOT NULL,
    password   VARCHAR(256)          NOT NULL,
    country_id BIGINT                NOT NULL,
    city_id    BIGINT                NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES t_countries (id),
    FOREIGN KEY (city_id) REFERENCES t_cities (id)
);

CREATE TABLE t_roles
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(100)          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE t_users_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE t_sessions
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    token      VARCHAR(192)          NOT NULL,
    user_id    BIGINT                NOT NULL,
    expires_at TIMESTAMP             NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES t_users (id)
);

-- #################### VIEWS ####################

CREATE OR REPLACE VIEW vw_users_roles AS
SELECT user.id       AS user_id,
       user.username AS username,
       role.id       AS role_id,
       role.name     AS role_name
FROM t_users user
         JOIN t_users_roles user_role on user.id = user_role.user_id
         JOIN t_roles role on user_role.role_id = role.id;

CREATE OR REPLACE VIEW vw_users_sessions AS
SELECT session.id,
       session.token,
       session.user_id,
       session.expires_at,
       user.username
FROM t_sessions session
         JOIN t_users user on user.id = session.user_id;

-- #################### TEST DATA ####################

INSERT INTO t_countries (id, name)
VALUES (1, 'Казахстан');

INSERT INTO t_cities (id, name, country_id)
VALUES (1, 'Алматы', 1),
       (2, 'Астана', 1);
