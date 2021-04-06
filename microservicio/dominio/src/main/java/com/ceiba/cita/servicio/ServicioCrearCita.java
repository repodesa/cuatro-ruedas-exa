package com.ceiba.cita.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;

import java.time.LocalDate;

public class ServicioCrearCita {

    public static final Integer CANTIDAD_CITAS_DIARIAS = 10;
    public static final Integer INCREMENTO_VALOR_DIA_FESTIVO = 2;

    private static final String EXISTE_UNA_CITA_PROGRAMADA_PARA_EL_VEHICLO_EN_LA_FECHA = "El vehículo ya tiene agendado una cita para la misma fecha.";
    private static final String EXISTE_UNA_CITA_PROGRAMADA_EN_LA_FECHA_HORA = "Ya existe una cita agendada en la misma hora y fecha.";

    private final RepositorioCita repositorioCita;

    public ServicioCrearCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }


    public Long ejecutar(Cita cita) {

        LocalDate fechaEntradaVehiculo = cita.getFechaEntrada();
        LocalDate fechaSalidaVehiculo = cita.getFechaSalida();

        if (cantidadDeCitasPorDiasSobrePasaPermitidas(fechaEntradaVehiculo)) {
            cita.setFechaEntrada(fechaEntradaVehiculo.plusDays(1));
            cita.setFechaSalida(fechaSalidaVehiculo.plusDays(1));
        }

        if (ServicioCalendario.esDiaFestivo(fechaEntradaVehiculo)) {
            cita.setValor(cita.getValor() * INCREMENTO_VALOR_DIA_FESTIVO);
        }

        cita.setFechaEntrada(fechaEntradaVehiculo.plusDays(ServicioCalendario.diaHabilCalendario(fechaEntradaVehiculo)));
        cita.setFechaSalida(fechaSalidaVehiculo.plusDays(ServicioCalendario.diaHabilCalendario(fechaSalidaVehiculo)));

        if (repositorioCita.existePorFechaVehiculo(fechaEntradaVehiculo, cita.getPlacaVehiculo())) {
            throw new ExcepcionDuplicidad(EXISTE_UNA_CITA_PROGRAMADA_PARA_EL_VEHICLO_EN_LA_FECHA);
        }
        if (repositorioCita.existePorFechaHora(fechaEntradaVehiculo, cita.getHoraEntrada())) {
            throw new ExcepcionDuplicidad(EXISTE_UNA_CITA_PROGRAMADA_EN_LA_FECHA_HORA);
        }
        return repositorioCita.crear(cita);
    }

    private boolean cantidadDeCitasPorDiasSobrePasaPermitidas(LocalDate fecha) {
        return (repositorioCita.cantidadCitasPorFecha(fecha) > CANTIDAD_CITAS_DIARIAS);
    }

}
