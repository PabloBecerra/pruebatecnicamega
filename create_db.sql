#Script para la creación de la base de datos en MySQL/MariaDB

CREATE DATABASE mega; 
USE mega;

CREATE TABLE clientes ( 
  id_cliente INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL, 
  email VARCHAR(150) UNIQUE NOT NULL,
  telefono VARCHAR(15),  
  direccion VARCHAR(255)
);

CREATE TABLE pedidos (
  id_pedido INT AUTO_INCREMENT PRIMARY KEY, 
  id_cliente INT NOT NULL,
  fecha_pedido DATE NOT NULL,
  total DECIMAL(10, 2) NOT NULL, 
  estado ENUM('pendiente', 'enviado', 'cancelado') DEFAULT 'pendiente',
  CONSTRAINT fk_cliente FOREIGN KEY (id_cliente)
    REFERENCES clientes(id_cliente) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
