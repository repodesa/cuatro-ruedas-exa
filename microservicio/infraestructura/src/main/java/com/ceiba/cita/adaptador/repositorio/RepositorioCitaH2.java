package com.ceiba.cita.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public class RepositorioCitaH2 implements RepositorioCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cita", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cita", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "cita", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "cita", value = "existePorFechaVehiculo")
    private static String sqlExistePorFechaVehiculo;

    @SqlStatement(namespace = "cita", value = "existePorFechaHora")
    private static String sqlExisteFechaHora;

    @SqlStatement(namespace = "cita", value = "cantidadCitasPorFecha")
    private static String sqlCantidadPorFecha;

    public RepositorioCitaH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Cita cita) {
        return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear);
    }

    @Override
    public void actualizar(Cita cita) {
        this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existePorFechaVehiculo(LocalDate fecha, String placaVehiculo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fecha_entrada", fecha);
        parameterSource.addValue("placa_vehiculo", placaVehiculo);

        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorFechaVehiculo, parameterSource, Boolean.class);
    }

    @Override
    public boolean existePorFechaHora(LocalDate fecha, LocalTime hora) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fecha_entrada", fecha);
        parameterSource.addValue("hora_entrada", hora);

        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteFechaHora, parameterSource, Boolean.class);
    }

    @Override
    public Integer cantidadCitasPorFecha(LocalDate fecha) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("fecha_entrada", fecha);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlCantidadPorFecha, parameterSource, Integer.class);
    }
}
