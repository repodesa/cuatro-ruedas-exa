package com.ceiba.cliente.controlador;


import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.consulta.ManejadorListarCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/clientes")
@Api(tags = {"Controlador Comandos clientes"})
public class ConsultarControladorCliente {

    private final ManejadorListarCliente manejadorListarCliente;

    public ConsultarControladorCliente(ManejadorListarCliente manejadorListarCliente) {
        this.manejadorListarCliente = manejadorListarCliente;
    }

    @GetMapping
    @ApiOperation("Listar Clientes")
    public List<DtoCliente> listar() {
        return manejadorListarCliente.ejecutar();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Listar Clientes")
    public DtoCliente listarPorId(@PathVariable String id) {
        return manejadorListarCliente.ejecutar(id);
    }
}
