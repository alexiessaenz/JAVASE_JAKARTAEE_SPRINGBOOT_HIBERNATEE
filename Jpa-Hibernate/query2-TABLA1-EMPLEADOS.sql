create database empresa;
use  empresa;

create table empleados ( 
emp_no smallint(4) not null primary key,
apellido varchar(10),
oficio varchar(10), 
dir smallint,
fecha_alt date,
salario float(6,2),
comision float(6,2),
dept_no tinyint(2));

insert into empleados values (7369, 'SANCHEZ', 'EMPLEADO', 7902, '1990/12/17', 1040, NULL, 20);
insert into empleados values (7499, 'ARROYO', 'VENDEDOR', 7698, '1990/02/20', 1500, 390, 20);

