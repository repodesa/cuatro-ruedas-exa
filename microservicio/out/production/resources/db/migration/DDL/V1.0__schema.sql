create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cita (
 id int(11) not null auto_increment,
 placa_vehiculo varchar(6) not null,
 id_cliente varchar(22) null,
 fecha_registro datetime null,
 fecha_entrada datetime null,
 hora_entrada time null,
 fecha_salida datetime null,
 hora_salida time null,
 valor int,
 primary key (id)
);
