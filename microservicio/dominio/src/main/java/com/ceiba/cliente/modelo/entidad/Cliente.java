package com.ceiba.cliente.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.*;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Cliente {
    private static final String FECHA_NACIMIENTO_MAYOR_QUE_FECHA_ACTUAL = "La fecha de nacimiento debe ser menor a la fecha actual";
    private static final String CAMPO_OBLIGATORIO = ", es obligatorio";

    private String id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaRegistro;
    private LocalDate fechaNacimiento;
    private String direccion;

    public Cliente(String id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String direccion) {
        validarObligatorio(id, "ID".concat(CAMPO_OBLIGATORIO));
        validarLongitud(id, 1, "ID".concat(CAMPO_OBLIGATORIO));
        validarObligatorio(primerNombre, "Primer Nombre".concat(CAMPO_OBLIGATORIO));
        validarLongitud(primerNombre, 1, "Primer Nombre".concat(CAMPO_OBLIGATORIO));
        validarObligatorio(primerApellido, "Primer Apellido".concat(CAMPO_OBLIGATORIO));
        validarLongitud(primerApellido, 1, "Primer Apellido".concat(CAMPO_OBLIGATORIO));
        validarObligatorio(fechaNacimiento, "Fecha Nacimiento".concat(CAMPO_OBLIGATORIO));
        validarObligatorio(direccion, "Dirección".concat(CAMPO_OBLIGATORIO));
        validarLongitud(direccion, 1, "Dirección".concat(CAMPO_OBLIGATORIO));
        superaFechaRegistro(fechaNacimiento, FECHA_NACIMIENTO_MAYOR_QUE_FECHA_ACTUAL);

        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaRegistro = LocalDate.now();
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
}
