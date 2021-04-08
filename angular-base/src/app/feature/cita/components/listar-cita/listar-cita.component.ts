import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Cita } from '../../shared/model/cita';
import { CitaService } from '../../shared/service/cita.service';


@Component({
  selector: 'app-listar-cita',
  templateUrl: './listar-cita.component.html'
})
export class ListarCitaComponent implements OnInit {

  public listaCitas: Observable<Cita[]>;

  constructor(protected citaServicio: CitaService) { }

  ngOnInit(): void {
    this.listaCitas = this.citaServicio.consultar();
  }

}
