DROP DATABASE IF EXISTS kleiton;
CREATE DATABASE kleiton;
USE kleiton;

CREATE TABLE macarroes (
    id          INT PRIMARY KEY AUTO_INCREMENT,
    tipo        VARCHAR(100) NOT NULL,
    marca       VARCHAR(100) NOT NULL,
    peso        DOUBLE NOT NULL,
    aldente     BOOLEAN NOT NULL
);
