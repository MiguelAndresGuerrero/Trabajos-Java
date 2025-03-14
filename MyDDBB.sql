create database MyDDBB;

use MyDDBB;

create table Usuarios (
	id int primary key,
    nombre varchar(20),
    apellido varchar(20),
    edad int
);

insert into Usuarios (id, nombre, apellido, edad) values
(1, 'Andres', 'Guerrero', '19');

SELECT * FROM Usuarios;