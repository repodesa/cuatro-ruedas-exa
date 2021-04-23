package com.ceiba.cliente.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.comando.ComandoCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {
    public Cliente crear(ComandoCliente comandoCliente) {
        return new Cliente(comandoCliente.getId(),
                           comandoCliente.getPrimerNombre(),
                           comandoCliente.getSegundoNombre(),
                           comandoCliente.getPrimerApellido(),
                           comandoCliente.getSegundoApellido(),
                           comandoCliente.getFechaNacimiento(),
                           comandoCliente.getDireccion());
    }
}
