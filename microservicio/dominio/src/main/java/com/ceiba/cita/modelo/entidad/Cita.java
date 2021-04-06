package com.ceiba.cita.modelo.entidad;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

;

@Getter
@ToString
public class Cita {

    private static final String FEHCHA_SALIDA_MAYOR_FECHA_ENTRADA = "La fecha de salida debe ser mayor a la fecha de entrada.";
    private static final String FECHA_ENTRADA_MAYOR_QUE_FECHA_REGISTRO = "El sistema solo permite fechas de salidas superiores a hoy.";
    private static final String VALOR_DIFERENTE_NULO = "Defina un valor para la Cita mayor a Cero(0).";
    private static final String VALOR_MAYOR_CERO = "El Valor de la cita NO puede ser igual o menor a Cero (0).";
    private static final String HORA_ENTRADA_RANGO_VALIDO = "La hora debe estar en el rango de ";

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

        fechaEntradaMayorQueFechaRegistro(fechaEntrada, FECHA_ENTRADA_MAYOR_QUE_FECHA_REGISTRO);
        fechaSalidaMayorQueFechaRegistro(fechaSalida, FEHCHA_SALIDA_MAYOR_FECHA_ENTRADA);
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

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
