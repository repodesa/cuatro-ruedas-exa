import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { Cita } from '@cita/shared/model/cita';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs';
import { CitaService } from '../../shared/service/cita.service';

import { ListarCitaComponent } from './listar-cita.component';

describe('ListarCitaComponent', () => {
  let component: ListarCitaComponent;
  let fixture: ComponentFixture<ListarCitaComponent>;
  let citaServicio: CitaService;
  let fecha = new Date();
  const listarCita: Cita[] = [new Cita(1, 'KIP050', '1113522472', new Date('2021-04-20'), new Date('2021-04-20'), fecha.getHours(), new Date('2021-04-20'), fecha.getHours(), 120000)];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListarCitaComponent],
      providers: [CitaService, HttpService],
      imports: [HttpClientTestingModule,
        CommonModule,
        HttpClientModule,
        RouterTestingModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarCitaComponent);
    component = fixture.componentInstance;
    citaServicio = TestBed.inject(CitaService);
    spyOn(citaServicio, 'consultar').and.returnValue(of(listarCita));
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.listaCitas.subscribe(resultado => {
      expect(1).toBe(resultado.length);
    });
  });
});
