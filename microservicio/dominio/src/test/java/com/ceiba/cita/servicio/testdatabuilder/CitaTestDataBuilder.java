package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.modelo.entidad.Cita;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CitaTestDataBuilder {
    private Long id;
    private String placaVehiculo;
    private String idClilente;
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private Double valor;

    public CitaTestDataBuilder() {
        id = 1L;
        placaVehiculo = "KIP059";
        idClilente = "31626136";
        fechaEntrada = LocalDate.now();
        horaEntrada = LocalTime.of(9, 0, 0);
        fechaSalida = LocalDate.now().plusDays(1);
        horaSalida = LocalTime.of(9, 0, 0);
        valor = 10000.0;
    }

    public CitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder conPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
        return this;
    }

    public CitaTestDataBuilder conIdCliente(String idClilente) {
        this.idClilente = idClilente;
        return this;
    }

    public CitaTestDataBuilder conFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public CitaTestDataBuilder conHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public CitaTestDataBuilder conFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public CitaTestDataBuilder conHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public CitaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public Cita build() {
        return new Cita(id, placaVehiculo, idClilente, fechaEntrada, horaEntrada, fechaSalida, horaSalida, valor);
    }
}
