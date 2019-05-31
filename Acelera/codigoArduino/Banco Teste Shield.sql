CREATE DATABASE testearduino;
USE testeArduino;

CREATE TABLE sensores
(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sensor1 VARCHAR(15) NOT NULL,
    sensor2 VARCHAR(15) NOT NULL,
    sensor3 VARCHAR(15) NOT NULL,
    datahora DATETIME DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM sensores;