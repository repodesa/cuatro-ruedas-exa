package com.ceiba.cita.controlador;

import com.ceiba.cita.consulta.ManejadorListarCitas;
import com.ceiba.cita.modelo.dto.DtoCita;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/citas")
@Api(tags = {"Controlador Comandos citas"})
public class ConsultarControladorCita {

    private final ManejadorListarCitas manejadorListarCitas;

    public ConsultarControladorCita(ManejadorListarCitas manejadorListarCitas) {
        this.manejadorListarCitas = manejadorListarCitas;
    }

    @GetMapping
    @ApiOperation("Listar Citas")
    public List<DtoCita> listar() {
        return this.manejadorListarCitas.ejecutar();
    }
}
