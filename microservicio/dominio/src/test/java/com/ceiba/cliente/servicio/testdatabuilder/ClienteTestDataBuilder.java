package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

import java.time.LocalDate;

public class ClienteTestDataBuilder {
    private String id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaRegistro;
    private LocalDate fechaNacimiento;
    private String direccion;

    public ClienteTestDataBuilder() {
        this.id = "77788899";
        this.primerNombre = "pepe";
        this.segundoNombre = "fulano";
        this.primerApellido = "perez";
        this.segundoApellido = "fulanito";
        this.fechaRegistro = LocalDate.now();
        this.fechaNacimiento = LocalDate.of(1990, 9, 30);
        this.direccion = "Calle sin salida";
    }

    public ClienteTestDataBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }

    public ClienteTestDataBuilder conSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }

    public ClienteTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public ClienteTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public ClienteTestDataBuilder conFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }

    public ClienteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Cliente build() {
        return new Cliente(id, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, direccion);
    }
}
