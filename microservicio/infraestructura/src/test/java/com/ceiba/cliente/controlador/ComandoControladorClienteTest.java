package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crearClienteOkTest() throws Exception {
        // Arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().build();
        // act-assert
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 'Ok'}"));
    }

    @Test
    public void crearClienteErrorTest() throws Exception {
        // Arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conId("11111111111111111111111111").build();
        // act-assert
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void crearClienteQueYaExisteErrorTest() throws Exception {
        // Arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conId("16883285").build();
        // act-assert
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionDuplicidad','mensaje':'Ya existe registrado un cliente con el mismo ID'}"));
    }

    @Test
    public void errorCrearClienteCampoNuloTest() throws Exception {
        // Arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conId(null).build();
        // act-assert
        mockMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionValorObligatorio','mensaje':'ID, es obligatorio'}"));
    }


    @Test
    public void actualizaClienteOkTest() throws Exception {
        // Arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conId("16883285").build();
        // act-assert
        mockMvc.perform(put("/clientes/{id}", comandoCliente.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());
    }

    @Test
    public void errorCuandoActualizaClienteQueNoExisteTest() throws Exception {
        // Arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conId("12345668").build();
        // act-assert
        mockMvc.perform(put("/clientes/{id}", comandoCliente.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{'nombreExcepcion':'ExcepcionRegistroNoExiste','mensaje':'El cliente no existe.'}"));
    }
}