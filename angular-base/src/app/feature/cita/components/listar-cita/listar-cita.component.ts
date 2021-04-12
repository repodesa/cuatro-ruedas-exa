import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Cita } from '../../shared/model/cita';
import { CitaService } from '../../shared/service/cita.service';


@Component({
  selector: 'app-listar-cita',
  templateUrl: './listar-cita.component.html'
})
export class ListarCitaComponent implements OnInit {

  titulo:String = "Listado de citas programadas.";
  messageErro: String;
  public listaCitas: Observable<Cita[]>;

  constructor(protected citaServicio: CitaService) { }

  ngOnInit(): void {
    this.listaCitas = this.citaServicio.consultar();    
    if (this.listaCitas == null) {
      this.messageErro = "No se encontraron registros para mostrar.";
    }
  }

}
