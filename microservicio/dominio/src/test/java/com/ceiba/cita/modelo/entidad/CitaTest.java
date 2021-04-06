package com.ceiba.cita.modelo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cita.servicio.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionFechaHora;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CitaTest {

    private static final String FEHCHA_SALIDA_MAYOR_FECHA_ENTRADA = "La fecha de salida debe ser mayor a la fecha de entrada.";
    private static final String FECHA_ENTRADA_MAYOR_QUE_FECHA_REGISTRO = "El sistema solo permite fechas de salidas superiores a hoy.";
    private static final String VALOR_MAYOR_CERO = "El Valor de la cita NO puede ser igual o menor a Cero (0).";
    private static final String HORA_ENTRADA_RANGO_VALIDO = "La hora debe estar en el rango de ";
    private static final String HORA_ENTRADA_MAYOR_HORA_SALIDA = "No se permiten registrar horas de entradas posteriores a las horas de salidas o viceversa.";
    private static final String DEFINA_UN_HORARIO_PARA_LA_CITA = "El horario para la agenda debe ser definido.";


    @Test
    public void validaFechaEntradaMenorQueFechaRegistroTest() {
        //Arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFechaEntrada(LocalDate.of(2021, 03, 01));
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionFechaHora.class, FECHA_ENTRADA_MAYOR_QUE_FECHA_REGISTRO);
    }

    @Test
    public void validaFechaSalidaMenorQueFechaRegistroTets() {
        //Arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conFechaSalida(LocalDate.of(2021, 03, 01));
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionFechaHora.class, FEHCHA_SALIDA_MAYOR_FECHA_ENTRADA);
    }

    @Test
    public void validaHoraEntradaNoRangoValidoTest() {
        //Arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conHoraEntrada(LocalTime.of(05, 0, 0));
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionFechaHora.class, HORA_ENTRADA_RANGO_VALIDO);
    }

    @Test
    public void validaHoraEntradaNulaTest() {
        //Arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conHoraEntrada(null);
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionFechaHora.class, DEFINA_UN_HORARIO_PARA_LA_CITA);
    }

    @Test
    public void validaHoraEntradaVsHoraSalidaTest() {
        //Arrange
        LocalTime ldtHoraValida = LocalTime.of(17, 0, 0);
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conHoraEntrada(ldtHoraValida).conHoraSalida(LocalTime.of(6, 00, 00));
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionFechaHora.class, HORA_ENTRADA_MAYOR_HORA_SALIDA);
    }

    @Test
    public void validarValorCitaMayorACeroTets() {
        //Arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conValor(0.0);
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionValorInvalido.class, VALOR_MAYOR_CERO);

    }

    @Test
    public void validarValorCitaNuloTets() {
        //Arrange
        CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().conValor(null);
        //act - assert
        BasePrueba.assertThrows(() -> citaTestDataBuilder.build(), ExcepcionValorInvalido.class, VALOR_MAYOR_CERO);

    }
}