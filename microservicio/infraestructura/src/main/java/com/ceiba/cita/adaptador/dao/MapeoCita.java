package com.ceiba.cita.adaptador.dao;

import com.ceiba.cita.modelo.dto.DtoCita;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet rs, int rowNum) throws SQLException {

        Long id = rs.getLong("id");
        String placaVehiculo = rs.getString("placa_vehiculo");
        String idCliente = rs.getString("id_cliente");
        LocalDate fechaRegistro = extraerLocalDate(rs, "fecha_registro");
        LocalDate fechaEntrada = extraerLocalDate(rs, "fecha_entrada");
        LocalTime horaEntrada = extraerLocalTime(rs, "hora_entrada");
        LocalDate fechaSalida = extraerLocalDate(rs, "fecha_salida");
        LocalTime horaSalida = extraerLocalTime(rs, "hora_salida");
        Double valor = rs.getDouble("valor");

        return new DtoCita(id, placaVehiculo, idCliente, fechaRegistro, fechaEntrada, horaEntrada, fechaSalida, horaSalida, valor);
    }
}
