export class Cita {
    id: Number;
    placaVehiculo: String;
    idCliente: String;
    fechaRegistro: Date;
    fechaEntrada: Date;
    horaEntrada: Number;
    fechaSalida: Date;
    horaSalida: Number;
    valor: Number;

    constructor(id: Number, placaVehiculo: String, idCliente: String, fechaRegistro: Date, fechaEntrada: Date, horaEntrada: Number, fechaSalida: Date, horaSalida: Number, valor: Number) {
        this.id = id;
        this.placaVehiculo = placaVehiculo;
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.valor = valor;
    }
}
