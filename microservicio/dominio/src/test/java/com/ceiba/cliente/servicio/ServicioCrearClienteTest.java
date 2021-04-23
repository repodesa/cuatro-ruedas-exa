package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearClienteTest {

    @InjectMocks
    private final ServicioCrearCliente servicioCrearCliente = null;

    @Mock
    private final RepositorioCliente repositorioCliente = null;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addCustomerOkTest() {
        Cliente cliente = new ClienteTestDataBuilder().build();
        Mockito.when(repositorioCliente.existe(cliente.getId())).thenReturn(false);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn("Ok");
        servicioCrearCliente.ejecutar(cliente);
        Mockito.verify(repositorioCliente, Mockito.times(1)).crear(cliente);
    }

    @Test(expected = ExcepcionDuplicidad.class)
    public void whenCustomerExistsExceptionTest() {
        Cliente cliente = new ClienteTestDataBuilder().build();
        Mockito.when(repositorioCliente.existe(cliente.getId())).thenReturn(true);
        servicioCrearCliente.ejecutar(cliente);
    }

    @Test
    public void crearClientesOkTest() {
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(cliente.getId())).thenReturn(false);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn("Ok");
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        servicioCrearCliente.ejecutar(cliente);
        Mockito.verify(repositorioCliente, Mockito.times(1)).crear(cliente);
    }

    @Test
    public void cuandoElClienteExisteTest() {
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(cliente.getId())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class, "Ya existe registrado un cliente con el mismo ID");
    }
}