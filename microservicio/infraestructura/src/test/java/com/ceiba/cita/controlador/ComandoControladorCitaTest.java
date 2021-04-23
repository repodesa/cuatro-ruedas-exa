package com.ceiba.cita.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cita.servicio.testdatabuilder.ComandoCitaTestDataBuilder;
import com.ceiba.cita.comando.ComandoCita;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCita.class)
public class ComandoControladorCitaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private ComandoCita comandoCita;

    @Before
    public void init() {
        comandoCita = new ComandoCitaTestDataBuilder().build();
    }

    @Test
    public void validaCrearCitaOkTest() throws Exception {
        comandoCita = new ComandoCitaTestDataBuilder().conFechaEntrada(LocalDate.now()).build();
        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 12}"));
    }

    @Test
    public void validaCrearCitaIncrementoValorPorDiaFestivoTest() throws Exception {
        comandoCita = new ComandoCitaTestDataBuilder().conFechaEntrada(LocalDate.of(2021, 05, 17)).build();

        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 11}"));
    }

    @Test
    public void validaExisteUnaCitaProgramadaParaLaPlacaEnLaFechaTest() throws Exception {
        comandoCita = new ComandoCitaTestDataBuilder().conPlacaVehiculo("KIP059").build();
        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validaExisteUnaCitaProgramadaEnLaMismaHoraTest() throws Exception {
        comandoCita = new ComandoCitaTestDataBuilder().conPlacaVehiculo("KIP059")
                .conHoraEntrada(LocalTime.of(9, 05))
                .conHoraSalida(LocalTime.of(9, 05))
                .build();
        mockMvc.perform(post("/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCita)))
                .andExpect(status().isBadRequest());
    }
}