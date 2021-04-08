import { Component, OnInit } from '@angular/core';
import { Cita } from '../../shared/model/cita';
import { CitaService } from '../../shared/service/cita.service';

@Component({
  selector: 'app-crear-cita',
  templateUrl: './crear-cita.component.html'
})
export class CrearCitaComponent implements OnInit {

  titulo: String = "Registrar Cita";
  cita: Cita = null;//new Cita();

  constructor(private citaService: CitaService) { }

  ngOnInit(): void {
  }

  create() {
    if (this.cita != null) {
      console.log(this.cita);
      this.citaService.guardar(this.cita);
    } else {
      alert("El registro de la cita no es valido");
    }
  }
}
