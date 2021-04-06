package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.cita.modelo.entidad.Cita;
import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    public Cita crear (ComandoCita comandoCita){
        return new Cita(comandoCita.getId(), comandoCita.getPlacaVehiculo(), comandoCita.getIdCliente(),
                        comandoCita.getFechaEntrada(),comandoCita.getHoraEntrada(),
                        comandoCita.getFechaSalida(), comandoCita.getHoraSalida(),
                        comandoCita.getValor());
    }
}
