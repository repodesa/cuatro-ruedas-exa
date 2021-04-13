import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { CitaService } from '@cita/shared/service/cita.service';
import { HttpService } from '@core/services/http.service';
import { of } from 'rxjs';

import { CrearCitaComponent } from './crear-cita.component';

describe('CrearCitaComponent', () => {
  let component: CrearCitaComponent;
  let fixture: ComponentFixture<CrearCitaComponent>;
  let citaServicio: CitaService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CrearCitaComponent],
      imports: [CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule],
      providers: [CitaService, HttpService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearCitaComponent);
    component = fixture.componentInstance;
    citaServicio = TestBed.inject(CitaService);
    spyOn(citaServicio, 'guardar').and.returnValue(of(true));
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario vacio es invalido', () => {
    expect(component.citaForm.valid).toBeFalsy();
  });

  it('Registrando la cita Error', () => {
    expect(component.citaForm.valid).toBeFalsy();
    component.citaForm.controls.placaVehiculo.setValue('KIP059');
    component.citaForm.controls.idCliente.setValue('123456789');
    component.citaForm.controls.fechaEntrada.setValue(new Date('2021-04-13'));
    //component.citaForm.controls.horaEntrada.setValue('07:00 AM');
    component.citaForm.controls.fechaSalida.setValue(new Date('2021-04-13'));
    //component.citaForm.controls.horaSaldia.setValue('07:00 AM');
    component.citaForm.controls.valor.setValue(10000.0);

    expect(component.citaForm.valid).toBeTruthy
    component.create();
    expect(component.citaForm.controls.id).toBeUndefined();
  });
});
