-- Crear base de datos
CREATE DATABASE IF NOT EXISTS mega;
USE mega;


-- Crear tabla cliente 
CREATE TABLE cliente ( 
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,  
    telefono VARCHAR(255),
    email VARCHAR(255),
    direccion VARCHAR(255)
) ENGINE=InnoDB;



-- Crear tabla pedido
CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,  
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id) 
        ON DELETE CASCADE
        ON UPDATE CASCADE
)   ENGINE=InnoDB;


