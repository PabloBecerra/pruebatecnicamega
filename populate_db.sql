USE mega;


INSERT INTO cliente (nombre, email, telefono, direccion)
VALUES 
    ('Juanito Pérez', 'juanito.perez@fknemail.cl', '+56930302928', 'LAS PETUNIAS 123'),
    ('Marta López', 'marta.lopez@mailcito.cL', '+56946573829', 'FLORINDA MEZA 4321'),
    ('Carlos Gómez', 'carlos.gomez@elcorreo.cl', '+56928374650', ' CHRIS CORNELL AVENUE 666'),
    ('Luis Jara', 'tancercade@tuscorreos.oo', '+56920394857', 'AVENIDA LA FLORIDA 456'),
    ('Mike Patton', 'mike.patton@tucorreo.com', '+56938475647', 'HOLANDA 123');



INSERT INTO pedido (id_cliente, descripcion, total)
VALUES
    (1, 'PANTUFLAS', 5000),
    (2, 'PIJAMA', 3000),
    (1, 'CHALECO', 2000),
    (3, 'BUFANDA', 4500),
    (5, 'CINTURON', 10000),
    (4, 'CALCETINES', 1500);



