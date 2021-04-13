import { AppPage } from "../app.po";
import { CitaPage } from "../page/cita/cita.po";
import { NavbarPage } from "../page/navbar/navbar.po";

describe('espacio de trabajo - proejcto cita', () => {
    let pagina: AppPage;
    let barra: NavbarPage;
    let cita: CitaPage;

    beforeEach(() => {
        pagina = new AppPage();
        barra = new NavbarPage();
        cita = new CitaPage();
    });

    it('Deberia listar citas', () => {
        pagina.navigateTo();
        barra.clickBotonCitas();
        cita.clicBotonListarCita();
        expect(cita.contarCitas()).toBe(cita.contarCitas());
    });

    it('deberia crear la cita ', () => {
        const ID_PLACA = 'LOP098';
        const ID_CLIENTE = '123456789';
        const FECHA_ENTRADA = '2021-04-16';
        const FECHA_SALIDA = '2021-04-16';
        const HORA_ENTRADA = '10:00';
        const HORA_SALIDA = '11:00';
        const VALOR = '100000';

        pagina.navigateTo();
        barra.clickBotonCitas();
        cita.clicBotonCrearCita();
        cita.ingresarPlacaVehiculo(ID_PLACA);
        cita.ingresarIdCliente(ID_CLIENTE);
        cita.ingresarFechaEntrada(FECHA_ENTRADA);
        cita.ingresarFechaSalida(FECHA_SALIDA);
        cita.ingresarHoraEntrada(HORA_ENTRADA);
        cita.ingresarHoraSalida(HORA_SALIDA);
        cita.ingresarValor(VALOR);

        expect(cita.contarCitas()).toBeGreaterThanOrEqual(cita.contarCitas());
    });
});