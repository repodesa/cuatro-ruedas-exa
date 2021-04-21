import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CitaService } from '../../shared/service/cita.service';

const LONGITUD_MINIMA_PERMITIDA_CLIENTE = 3;
const LONGITUD_MAXIMA_PERMITIDA_CLIENTE = 11;
const LONGITUD_MINIMA_PERMITIDA_PLACA = 5;
const LONGITUD_MAXIMA_PERMITIDA_PLACA = 6;

@Component({
  selector: 'app-crear-cita',
  templateUrl: './crear-cita.component.html'
})
export class CrearCitaComponent implements OnInit {

  citaForm: FormGroup;
  titulo: String = "Registrar Cita";
  messageErro: String = null;
  message: String = null;
  constructor(private citaService: CitaService) { }

  ngOnInit(): void {
    this.construirFormularioCita();
  }

  private construirFormularioCita() {
    this.citaForm = new FormGroup({
      placaVehiculo: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_PLACA),
                                                               Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_PLACA)]),
      idCliente: new FormControl('', [Validators.required, Validators.minLength(LONGITUD_MINIMA_PERMITIDA_CLIENTE),
                                                           Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_CLIENTE)]),
      valor: new FormControl('0.0', Validators.required),
      fechaEntrada: new FormControl('', Validators.required),
      fechaSalida: new FormControl('', Validators.required),
      horaEntrada: new FormControl('', Validators.required),
      horaSalida: new FormControl('', Validators.required)
    });
  }

  create() {
    if (this.citaForm.valid) {
      this.citaService.guardar(this.citaForm.value).subscribe(data => {
        this.message = "Codigo de cita ["+data['valor']+"]";
        this.messageErro = null;
      }, err => {
        this.messageErro = err.error.mensaje;
        this.message = null;
      })
    }else {
      this.messageErro = "Diligencia el formulario correctamente..!"
      this.message = null;
    }
  }
}