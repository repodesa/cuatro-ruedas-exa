package com.ceiba.cita.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.cita.comando.ComandoCita;
import com.ceiba.cita.comando.fabrica.FabricaCita;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.servicio.ServicioCrearCita;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>> {

    private final FabricaCita fabricaCita;
    private final ServicioCrearCita servicioCrearCita;

    public ManejadorCrearCita(FabricaCita fabricaCita, ServicioCrearCita servicioCrearCita) {
        this.fabricaCita = fabricaCita;
        this.servicioCrearCita = servicioCrearCita;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoCita comando) {
        Cita cita = this.fabricaCita.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita));
    }
}
