package com.ceiba.cita.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
@Api(tags = {"Controlador Comandos citas"})
public class ComandoControladorCita {

    private final ManejadorCrearCita manejadorCrearCita;

    public ComandoControladorCita(ManejadorCrearCita manejadorCrearCita) {
        this.manejadorCrearCita = manejadorCrearCita;
    }

    @PostMapping
    @ApiOperation("Crear Cita")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCita comandoCita) {
        return manejadorCrearCita.ejecutar(comandoCita);
    }
}
