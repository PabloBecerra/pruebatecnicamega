USE mega;


INSERT INTO clientes (nombre, email, telefono, direccion)
VALUES 
    ('Juanito Pérez', 'juanito.perez@fknemail.cl', '+56930302928', 'LAS PETUNIAS 123'),
    ('Marta López', 'marta.lopez@mailcito.cL', '+56946573829', 'FLORINDA MEZA 4321'),
    ('Carlos Gómez', 'carlos.gomez@elcorreo.cl', '+56928374650', ' CHRIS CORNELL AVENUE 666'),
    ('Luis Jara', 'tancercade@tuscorreos.oo', '+56920394857', 'AVENIDA LA FLORIDA 456'),
    ('Mike Patton', 'mike.patton@tucorreo.com', '+56938475647', 'HOLANDA 123');



INSERT INTO pedidos (id_cliente, fecha_pedido, total)
VALUES
    (1, '2024-12-01', 5000),
    (2, '2024-12-02', 3000),
    (1, '2024-12-03', 2000),
    (3, '2024-12-03', 4500),
    (5, '2024-12-04', 10000),
    (4, '2024-12-05', 1500);



