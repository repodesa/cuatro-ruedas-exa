package com.ceiba.cita.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.manejador.ManejadorCrearCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
@Api(tags = {"Controlador Comandos citas"})
public class ComandoControladorCita {

    @Autowired
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
