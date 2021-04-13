import { Injectable } from '@angular/core';
import { HttpService } from '@core/services/http.service';
import { HOST_CITAS } from 'src/environments/environment';
import { Cita } from '../model/cita';

@Injectable()
export class CitaService {

  constructor(protected http: HttpService) { }

  public consultar() {
    return this.http.doGet<Cita[]>(`${HOST_CITAS.endpoint}/citas`, this.http.optsName('consultar citas'));
  }

  public guardar(cita: Cita) {
    console.log("cita := "+cita)
    return this.http.doPost<Cita, boolean>(`${HOST_CITAS.endpoint}/citas`, cita, this.http.optsName('crear/actualiza citas'));
  }
}
