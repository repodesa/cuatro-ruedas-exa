package com.ceiba.cita.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cita.modelo.entidad.Cita;
import com.ceiba.cita.puerto.repositorio.RepositorioCita;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;


public class ServicioCrearCitaTest {

    public static final int CANTIDAD_CITAS_DIARIAS = 11;
    private static final String EXISTE_UNA_CITA_PROGRAMADA_PARA_EL_VEHICLO_EN_LA_FECHA = "El vehículo ya tiene agendado una cita para la misma fecha.";
    private static final String EXISTE_UNA_CITA_PROGRAMADA_EN_LA_FECHA_HORA = "Ya existe una cita agendada en la misma hora y fecha.";

    @Test
    public void validarSuperaNumeroMaximoCitasPorDiaTest() {
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.cantidadCitasPorFecha(Mockito.any())).thenReturn(CANTIDAD_CITAS_DIARIAS);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        servicioCrearCita.ejecutar(cita);
        Mockito.verify(repositorioCita, Mockito.times(1)).crear(cita);
    }

    @Test
    public void esDiaFestivoCreandoCitaTest() {
        Cita cita = new CitaTestDataBuilder().
                conFechaEntrada(LocalDate.of(2021, 05, 17)).
                conFechaSalida(LocalDate.of(2021, 05, 18)).build();

        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.cantidadCitasPorFecha(Mockito.any())).thenReturn(CANTIDAD_CITAS_DIARIAS);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        servicioCrearCita.ejecutar(cita);
        Mockito.verify(repositorioCita, Mockito.times(1)).crear(cita);
        assertEquals(20000.0, cita.getValor(), 0);
    }

    @Test
    public void existeCitaProgramadaEnLaMismaFechaVehiculoTest() {
        Cita cita = new CitaTestDataBuilder().conIdCliente("16883285").conPlacaVehiculo("KIP059").conFechaEntrada(LocalDate.now()).build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.cantidadCitasPorFecha(Mockito.any())).thenReturn(CANTIDAD_CITAS_DIARIAS);
        Mockito.when(repositorioCita.existePorFechaVehiculo(LocalDate.now(), cita.getPlacaVehiculo())).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class, EXISTE_UNA_CITA_PROGRAMADA_PARA_EL_VEHICLO_EN_LA_FECHA);
    }

    @Test
    public void existeCitaProgramadaEnLaMismaFechaHoraTest() {
        Cita cita = new CitaTestDataBuilder().build();
        RepositorioCita repositorioCita = Mockito.mock(RepositorioCita.class);
        Mockito.when(repositorioCita.cantidadCitasPorFecha(Mockito.any())).thenReturn(CANTIDAD_CITAS_DIARIAS);

        Mockito.when(repositorioCita.existePorFechaHora(LocalDate.now(), LocalTime.of(9, 00))).thenReturn(true);
        ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
        BasePrueba.assertThrows(() -> servicioCrearCita.ejecutar(cita), ExcepcionDuplicidad.class, EXISTE_UNA_CITA_PROGRAMADA_EN_LA_FECHA_HORA);
    }
}