package com.ceiba.cita.puerto.repositorio;

import com.ceiba.cita.modelo.entidad.Cita;

import java.time.LocalDate;
import java.time.LocalTime;

public interface RepositorioCita {
    /**
     * Permite crear un usuario
     * @param cita
     * @return el id generado
     */
    Long crear(Cita cita);

    /**
     * Permite actualizar un usuario
     * @param cita
     */
    void actualizar(Cita cita);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Verifica la existencia de una placa ya registrada para la fecha
     * @param fecha
     * @param placaVehiculo
     * @return verdadero si la cita ya existe, falso en caso negativo.
     */
    boolean existePorFechaVehiculo (LocalDate fecha, String placaVehiculo);

    /**
     *
     * @param fecha
     * @param hora
     * @return
     */
    boolean existePorFechaHora (LocalDate fecha, LocalTime hora);


    /**
     *
     * @param fecha
     * @return
     */
    Integer cantidadCitasPorFecha (LocalDate fecha);
}
