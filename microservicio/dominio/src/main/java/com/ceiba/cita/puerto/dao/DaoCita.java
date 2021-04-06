package com.ceiba.cita.puerto.dao;

import com.ceiba.cita.modelo.dto.DtoCita;

import java.time.LocalDate;
import java.util.List;

public interface DaoCita {

    /**
     * Pemite listar todos los registros de las citas.
     * @return
     */
    List<DtoCita> Listar ();


    /**
     * Obtener citas programadas de acuerdo a una fecha.
     * @param fecha fecha para consultar citas.
     * @return las citas programadas de acuerdo a una fecha enviada
     */
    List<DtoCita> obtenerCitasPorFecha (LocalDate fecha);
}
