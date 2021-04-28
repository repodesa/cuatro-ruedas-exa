package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@Api(tags = {"Controlador Comandos clientes"})
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;

    @Autowired
    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente,
                                     ManejadorActualizarCliente manejadorActualizarCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
    }

    @PostMapping
    @ApiOperation("Crear Cliente")
    public ComandoRespuesta<String> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Crear Cliente")
    public void actualizar(@RequestBody ComandoCliente comandoCliente, @PathVariable String id) {
        comandoCliente.setId(id);
        manejadorActualizarCliente.ejecutar(comandoCliente);
    }

}
