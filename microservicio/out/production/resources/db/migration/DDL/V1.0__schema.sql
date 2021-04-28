create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
id varchar(22) not null,
primer_nombre varchar(60) not null,
segundo_nombre varchar(60),
primer_apellido varchar(60) not null,
segundo_apellido varchar(60),
fecha_creacion date not null,
fecha_nacimiento date not null,
direccion varchar(100),
primary key(id)
);

create table cita (
 id int(11) not null auto_increment,
 placa_vehiculo varchar(6) not null,
 id_cliente varchar(22) not null,
 fecha_registro date not null,
 fecha_entrada date not null,
 hora_entrada time null,
 fecha_salida date null,
 hora_salida time null,
 valor int,
 primary key (id),
 constraint fk_cita_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id)
);



