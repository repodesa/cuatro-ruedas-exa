package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<String>> {

    private final FabricaCliente fabricaCliente;
    private final ServicioCrearCliente servicioCrearCliente;

    public ManejadorCrearCliente(FabricaCliente fabricaCliente, ServicioCrearCliente servicioCrearCliente) {
        this.fabricaCliente = fabricaCliente;
        this.servicioCrearCliente = servicioCrearCliente;
    }

    @Override
    public ComandoRespuesta<String> ejecutar(ComandoCliente comando) {
        Cliente cliente = this.fabricaCliente.crear(comando);
        return new ComandoRespuesta<>(servicioCrearCliente.ejecutar(cliente));
    }
}