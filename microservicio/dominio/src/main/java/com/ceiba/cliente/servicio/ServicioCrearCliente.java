package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCliente {

    private static final String EXISTE_UN_CLIENTE_REGISTRADO_CON_EL_ID = "Ya existe registrado un cliente con el mismo ID";

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public String ejecutar(Cliente cliente) {
        if (repositorioCliente.existe(cliente.getId())) {
            throw new ExcepcionDuplicidad(EXISTE_UN_CLIENTE_REGISTRADO_CON_EL_ID);
        }
        return this.repositorioCliente.crear(cliente);
    }
}
