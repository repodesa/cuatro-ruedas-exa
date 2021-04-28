package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.time.LocalDate;

public class ComandoClienteTestDataBuilder {
    private String id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaNacimiento;
    private String direccion;

    public ComandoClienteTestDataBuilder() {
        id = "12345678";
        primerNombre = "pepe";
        segundoNombre = "fulano";
        primerApellido = "perez";
        segundoApellido = "fulanito";
        fechaNacimiento = LocalDate.of(1990, 9, 30);
        direccion = "Calle sin salida";
    }

    public ComandoClienteTestDataBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public ComandoClienteTestDataBuilder conPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
        return this;
    }

    public ComandoClienteTestDataBuilder conSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
        return this;
    }

    public ComandoClienteTestDataBuilder conPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public ComandoClienteTestDataBuilder conSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public ComandoClienteTestDataBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public ComandoClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoCliente build() {
        return new ComandoCliente(id, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, direccion);
    }
}
