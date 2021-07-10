DROP TABLE IF EXISTS sensors;

CREATE TABLE roles
(
    role_id     INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) DEFAULT NULL
);

CREATE TABLE sensors
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) DEFAULT NULL,
    model       VARCHAR(50) DEFAULT NULL,
    range_from  INT NOT NULL,
    range_to    INT NOT NULL,
    sensor_type VARCHAR(50) DEFAULT NULL,
    sensor_unit VARCHAR(50) DEFAULT NULL,
    location    VARCHAR(50) DEFAULT NULL,
    description VARCHAR(50) DEFAULT NULL
);