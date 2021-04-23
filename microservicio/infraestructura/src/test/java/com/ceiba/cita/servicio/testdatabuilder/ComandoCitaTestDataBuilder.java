package com.ceiba.cita.servicio.testdatabuilder;

import com.ceiba.cita.comando.ComandoCita;

import java.time.LocalDate;
import java.time.LocalTime;

public class ComandoCitaTestDataBuilder {
    private Long id;
    private String placaVehiculo;
    private String idClilente;
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private Double valor;

    public ComandoCitaTestDataBuilder() {
        id = 1L;
        placaVehiculo = "JIK226";
        idClilente = "1113522472";
        fechaEntrada = LocalDate.now();
        horaEntrada = LocalTime.of(7, 0, 0);
        fechaSalida = LocalDate.now().plusDays(1);
        horaSalida = LocalTime.of(9, 0, 0);
        valor = 10000.0;
    }

    public ComandoCitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCitaTestDataBuilder conPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
        return this;
    }

    public ComandoCitaTestDataBuilder conIdCliente(String idClilente) {
        this.idClilente = idClilente;
        return this;
    }

    public ComandoCitaTestDataBuilder conFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
        return this;
    }

    public ComandoCitaTestDataBuilder conHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public ComandoCitaTestDataBuilder conFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }

    public ComandoCitaTestDataBuilder conHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public ComandoCitaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ComandoCita build() {
        return new ComandoCita(id, placaVehiculo, idClilente, fechaEntrada, horaEntrada, fechaSalida, horaSalida, valor);
    }
}
