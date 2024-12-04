#Script para la creación de la base de datos en MySQL/MariaDB

CREATE DATABASE IF NOT EXISTS mega; 
USE mega;

CREATE TABLE cliente ( 
  id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL, 
  email VARCHAR(255) UNIQUE NOT NULL,
  telefono VARCHAR(255),  
  direccion VARCHAR(255)
);


CREATE TABLE pedido (
  id BIGINT(20) AUTO_INCREMENT PRIMARY KEY, 
  id_cliente BIGINT(20) NOT NULL,
  fecha_pedido DATE NOT NULL,
  total DECIMAL(10, 2) NOT NULL, 
  estado ENUM('pendiente', 'enviado', 'cancelado') DEFAULT 'pendiente',
  CONSTRAINT fk_cliente FOREIGN KEY (id_cliente)
    REFERENCES cliente(id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
