package com.ceiba.cliente.servicio;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionRegistroNoExiste;

public class ServicioActualizarCliente {
    private static final String CLIENTE_NO_EXISTE = "El cliente no existe.";
    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        validarExistenciaCliente(cliente.getId());
        repositorioCliente.actualizar(cliente);
    }

    private void validarExistenciaCliente(String id) {
        if (!repositorioCliente.existe(id)) {
            throw new ExcepcionRegistroNoExiste(CLIENTE_NO_EXISTE);
        }
    }
}
