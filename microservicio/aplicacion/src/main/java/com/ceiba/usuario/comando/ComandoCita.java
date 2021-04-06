package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComandoCita {

    private Long id;
    private String placaVehiculo;
    private String idCliente;
    private LocalDate fechaEntrada;
    private LocalTime horaEntrada;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private Double valor;

}
