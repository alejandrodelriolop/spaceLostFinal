CREATE DATABASE spacelost;

USE spacelost;

CREATE TABLE jugadores (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(50) UNIQUE NOT NULL,

    sala_actual VARCHAR(100),

    puntuacion INT DEFAULT 0
);