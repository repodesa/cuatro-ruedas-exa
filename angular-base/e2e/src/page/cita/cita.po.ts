import { by, element } from "protractor";

export class CitaPage {
    private linkCreaCita = element(by.id('linkCrearCita'));
    private linkListarCita = element(by.id('linkListarCitas'));
    private listaCita = element.all(by.css('table tbody tr'));
    private inputplacaVehiculo = element(by.id('placaVehiculo'));
    private inputIdCliente = element(by.id('idCliente'));
    private inputFechaEntrada = element(by.id('fechaEntrada'));
    private inputHoraEntrada = element(by.id('horaEntrada'));
    private inputFechaSalida = element(by.id('fechaSalida'));
    private inputHoraSalida = element(by.id('horaSalida'));
    private inputValor = element(by.id('valor'));

    async clicBotonCrearCita() {
        await this.linkCreaCita.click();
    }

    async clicBotonListarCita() {
        await this.linkListarCita.click();
    }

    async contarCitas() {
        return this.listaCita.count();
    }

    async ingresarPlacaVehiculo(placaVehiculo){
        await this.inputplacaVehiculo.sendKeys(placaVehiculo);
    }

    async ingresarIdCliente(idCliente){
        await this.inputIdCliente.sendKeys(idCliente);
    }    

    async ingresarFechaEntrada(fechaEntrada){
        await this.inputFechaEntrada.sendKeys(fechaEntrada);
    }

    async ingresarFechaSalida(fechaSalida){
        await this.inputFechaSalida.sendKeys(fechaSalida);
    }

    async ingresarHoraEntrada(horaEntrada){
        await this.inputHoraEntrada.sendKeys(horaEntrada);
    }

    async ingresarHoraSalida(horaSalida){
        await this.inputHoraSalida.sendKeys(horaSalida);
    }

    async ingresarValor(valor){
        await this.inputValor.sendKeys(valor);
    }
}
