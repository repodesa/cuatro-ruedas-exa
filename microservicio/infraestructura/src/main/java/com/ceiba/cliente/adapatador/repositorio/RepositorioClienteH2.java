package com.ceiba.cliente.adapatador.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClienteH2 implements RepositorioCliente {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "cliente", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "cliente", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "cliente", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "cliente", value = "existe")
    private static String sqlExiste;

    public RepositorioClienteH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public String crear(Cliente cliente) {
        return (this.customNamedParameterJdbcTemplate.crearA(cliente, sqlCrear) > 0 ? "Ok" : "Error");
    }

    @Override
    public void actualizar(Cliente cliente) {
        customNamedParameterJdbcTemplate.actualizar(cliente, sqlActualizar);
    }

    @Override
    public void eliminar(String id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(String id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }
}
