package com.ceiba.cita.servicio;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ServicioCalendarioTest {
    private static final LocalDate FECHA_DIA_SABADO = LocalDate.of(2021, 03, 27);
    private static final LocalDate FECHA_DIA_DOMINGO = LocalDate.of(2021, 03, 28);
    private static final LocalDate FECHA_DIA_LUNES = LocalDate.of(2021, 03, 29);

    private static final LocalDate FECHA_FESTIVO = LocalDate.of(2021, 03, 22);
    private static final LocalDate NO_FECHA_FESTIVO = LocalDate.of(2021, 03, 20);

    @Test
    public void validaDiasHabilesTest() {
        Long lgSabado = (long) 2;
        Long lgDomingo = (long) 1;
        Long lgLunes = (long) 0;
        assertEquals(ServicioCalendario.diaHabilCalendario(FECHA_DIA_DOMINGO), lgDomingo);
        assertEquals(ServicioCalendario.diaHabilCalendario(FECHA_DIA_SABADO), lgSabado);
        assertEquals(ServicioCalendario.diaHabilCalendario(FECHA_DIA_LUNES), lgLunes);
    }

    @Test
    public void esDiaFestivoTest() {
        assertTrue(ServicioCalendario.esDiaFestivo(FECHA_FESTIVO));
    }

    @Test
    public void noEsDiaFestivoTest() {
        assertFalse(ServicioCalendario.esDiaFestivo(NO_FECHA_FESTIVO));
    }
}