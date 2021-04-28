package com.ceiba.cliente.adapatador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {
    @Override
    public DtoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String primerNombre = rs.getString("primer_nombre");
        String segundoNombre = rs.getString("segundo_nombre");
        String primerApellido = rs.getString("primer_apellido");
        String segundoApellido = rs.getString("segundo_apellido");
        LocalDate fechaRegistro = extraerLocalDate(rs, "fecha_creacion");
        LocalDate fechaNacimiento = extraerLocalDate(rs, "fecha_nacimiento");
        String direccion = rs.getString("direccion");

        return new DtoCliente(id, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaRegistro, fechaNacimiento, direccion);
    }
}
