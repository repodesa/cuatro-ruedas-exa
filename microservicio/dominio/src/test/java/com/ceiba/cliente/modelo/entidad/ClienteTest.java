package com.ceiba.cliente.modelo.entidad;

import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionFechaHora;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static com.ceiba.BasePrueba.assertThrows;

public class ClienteTest {

    private ClienteTestDataBuilder clienteTestDataBuilder = null;

    @Before
    public void setUp() throws Exception {
        Cliente cliente = new ClienteTestDataBuilder().build();
    }

    @Test(expected = ExcepcionValorObligatorio.class)
    public void validaExcepcionCuandoLosCamposSonNulosTest() throws ExcepcionValorObligatorio {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conId(null).conPrimerNombre(null).conPrimerApellido(null).conFechaNacimiento(null).conDireccion(null);
        //act - assert
        Cliente cliente = clienteTestDataBuilder.build();
    }

    @Test
    public void validaCuandoIdEsNuloTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conId(null);
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "ID, es obligatorio");
    }

    @Test
    public void validaCuandoIdEsVacioTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conId("");
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "ID, es obligatorio");
    }

    @Test
    public void validaCuandoPrimerNombreEsNuloTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conPrimerNombre(null);
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Primer Nombre, es obligatorio");
    }

    @Test
    public void validaCuandoPrimerNombreEsVacioTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conPrimerNombre("");
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "Primer Nombre, es obligatorio");
    }

    @Test
    public void validaCuandoPrimerApellidoEsNuloTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conPrimerApellido(null);
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Primer Apellido, es obligatorio");
    }

    @Test
    public void validaCuandoPrimerApellidoEsVacioTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conPrimerApellido("");
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "Primer Apellido, es obligatorio");
    }

    @Test
    public void validaCuandoFechaNacimientoEsNuloTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaNacimiento(null);
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Fecha Nacimiento, es obligatorio");
    }

    @Test
    public void validaCuandoFechaNacimientoEsMayorQueHoyTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conFechaNacimiento(LocalDate.now().plusDays(1));
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionFechaHora.class, "La fecha de nacimiento debe ser menor a la fecha actual");
    }

    @Test
    public void validaCuandoDireccionEsNuloTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion(null);
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Dirección, es obligatorio");
    }

    @Test
    public void validaCuandoDireccionEsVacioTest() {
        //Arrange
        clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion("");
        //act - assert
        assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "Dirección, es obligatorio");
    }
}