import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from '@core/services/http.service';
import { HOST_CITAS } from 'src/environments/environment';
import { Cita } from '../model/cita';

import { CitaService } from './cita.service';

describe('CitaService', () => {

  let httpMock: HttpTestingController;
  let servicioCita: CitaService;
  const API_ENDPOINT_CITA_CONSULTA = `${HOST_CITAS.endpoint}/citas`;
  const API_ENDPOINT_CITA_CREA = `${HOST_CITAS.endpoint}/citas`;

  beforeEach(() => {
    const INJECTOR = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CitaService, HttpService]
    });
    httpMock = INJECTOR.inject(HttpTestingController);
    servicioCita = TestBed.inject(CitaService);
  });

  it('should be created', () => {
    const citaServicio: CitaService = TestBed.inject(CitaService);
    expect(citaServicio).toBeTruthy();
  });

  it('deberia listar citas', () => {
    let fecha = new Date();

    const dummyCitas = [new Cita(1, 'KIP050', '1113522472', new Date('2021-04-05'), new Date('2021-04-06'), fecha.getHours(), new Date('2021-04-06'), fecha.getHours(), 120000)];

    servicioCita.consultar().subscribe(citas => {
      expect(citas.length).toBe(1);
      expect(citas).toEqual(dummyCitas);
    });

    const req = httpMock.expectOne(API_ENDPOINT_CITA_CONSULTA);
    expect(req.request.method).toBe('GET');
    req.flush(dummyCitas);
  });

  it('deberia crear una cita', () => {
    let fecha = new Date();
    const dummyCitas = new Cita(1, 'KIP050', '1113522472', new Date('2021-04-05'), new Date('2021-04-06'), fecha.getHours(), new Date('2021-04-06'), fecha.getHours(), 120000);

    servicioCita.guardar(dummyCitas).subscribe((resultado) => {
      expect(resultado).toEqual(true);
    });

    const req = httpMock.expectOne(API_ENDPOINT_CITA_CREA);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({ body: true }));
  });
});
