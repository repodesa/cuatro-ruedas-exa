package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionRegistroNoExiste;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarClienteTest {

    private Cliente cliente = null;
    private RepositorioCliente repositorioCliente;
    private ServicioActualizarCliente servicioActualizarCliente;

    @Before
    public void setUp() throws Exception {
        cliente = new ClienteTestDataBuilder().build();
        // Mockeo el repositorio
        repositorioCliente = Mockito.mock(RepositorioCliente.class);
        servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
    }

    @Test
    public void clienteNoExisteTest() {
        // Mockeo los metodos del repositorio
        Mockito.when(repositorioCliente.existe(cliente.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionRegistroNoExiste.class, "El cliente no existe.");
    }

    @Test
    public void clienteExisteActualizaOkTest() {
        // Mockeo los metodos del repositorio
        Mockito.when(repositorioCliente.existe(cliente.getId())).thenReturn(true);
        // act - assert
        servicioActualizarCliente.ejecutar(cliente);
        Mockito.verify(repositorioCliente, Mockito.times(1)).actualizar(cliente);

    }
}