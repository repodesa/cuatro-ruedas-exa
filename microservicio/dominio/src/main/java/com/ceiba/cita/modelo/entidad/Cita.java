package com.ceiba.cita.modelo.entidad;

import com.ceiba.cita.servicio.ServicioCalendario;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.*;


@Getter
public class Cita {

    private static final String FECHA_ENTRADA_MENOR_QUE_FECHA_REGISTRO = "El sistema solo permite fechas de entrada superiores a hoy.";
    private static final String FEHCHA_SALIDA_MENOR_QUE_FECHA_REGISTRO = "La fecha de salida debe ser mayor a la fecha de hoy.";
    private static final String VALOR_MAYOR_CERO = "El Valor de la cita NO puede ser igual o menor a Cero (0).";
    private static final String HORA_ENTRADA_RANGO_VALIDO = "La hora debe estar en el rango de ";
    private static final Integer INCREMENTO_VALOR_DIA_FESTIVO = 2;

    private Long id;
    private String placaVehiculo;
    private String idCliente;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private Double valor;

    public Cita(Long id, String placaVehiculo, String idclilente, LocalDate fechaEntrada, LocalTime horaEntrada, LocalDate fechaSalida, LocalTime horaSalida, Double valor) {

        validarFechaRegistro(fechaEntrada, FECHA_ENTRADA_MENOR_QUE_FECHA_REGISTRO);
        validarFechaRegistro(fechaSalida, FEHCHA_SALIDA_MENOR_QUE_FECHA_REGISTRO);
        horaEntradaRangoValido(horaEntrada, horaSalida, HORA_ENTRADA_RANGO_VALIDO);
        valorDiferenteNuloMayorCero(valor, VALOR_MAYOR_CERO);

        this.id = id;
        this.placaVehiculo = placaVehiculo;
        this.idCliente = idclilente;
        this.fechaRegistro = LocalDate.now();
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.valor = valor;
    }

    public void incrementaDiaCitaProgramada() {
        this.fechaEntrada = this.fechaEntrada.plusDays(ServicioCalendario.diaHabilCalendario(this.fechaEntrada));
        this.fechaSalida = this.fechaSalida.plusDays(ServicioCalendario.diaHabilCalendario(this.fechaSalida));
    }

    public void duplicaValorPorDiaFestivo() {
        this.valor = this.valor * INCREMENTO_VALOR_DIA_FESTIVO;
    }
}
