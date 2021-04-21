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
  const listarCita: Cita[] =[new Cita(1, 'KIP050', '1113522472', new Date('2021-04-20'), new Date('2021-04-20'), fecha.getHours(), new Date('2021-04-20'), fecha.getHours(), 120000),
  new Cita(1, 'COI903', '16883285', new Date('2021-04-20'), new Date('2021-04-21'), fecha.getHours(), new Date('2021-04-21'), fecha.getHours(), 120000)];

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

  it('Debería listar y conocer la cantidad de registros ', async(() => {
    expect(component).toBeTruthy();
    component.listaCitas.subscribe(resultado => {
      expect(2).toBe(resultado.length);
    })
  }));

  it('Debería validar el titulo del formulario', async(() => {
    /*De esta manera se obtiene el valor del artefacto Html*/
    const ficture = TestBed.createComponent(ListarCitaComponent);
    ficture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('p').textContent).toContain('Listado de citas programadas.');
    expect(compiled.querySelector('p').textContent).toBe(component.titulo);
    expect(component.messageErro).toBeNull();
  }));
});
