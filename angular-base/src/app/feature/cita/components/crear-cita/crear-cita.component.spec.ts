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

  it('Debería crear el componente crear-cita', async(() => {
    expect(component).toBeTruthy();
  }));

  it('formulario vacio es invalido', async(() => {
    expect(component.citaForm.valid).toBeFalsy();
  }));

  it('Debería NO construir el formulario', async(() => {
    (<HTMLInputElement>document.getElementById('placaVehiculo')).value = null;
    (<HTMLInputElement>document.getElementById('idCliente')).value = null;
    (<HTMLInputElement>document.getElementById('fechaEntrada')).value = null;
    (<HTMLInputElement>document.getElementById('horaEntrada')).value = null;
    (<HTMLInputElement>document.getElementById('fechaSalida')).value = null;
    (<HTMLInputElement>document.getElementById('horaSalida')).value = null;
    (<HTMLInputElement>document.getElementById('valor')).value = null;    
    component.create();
    expect(component.citaForm.valid).toBeFalsy();
    expect(component.messageErro).toContain("Diligencia el formulario correctamente..!")
    expect(component.message).toBeNull;
  }));

  it('Registrando la cita Error', async(() => {
    component.citaForm.controls.placaVehiculo.setValue('KIP059');
    component.citaForm.controls.idCliente.setValue('123456789');
    component.citaForm.controls.fechaEntrada.setValue('04-01-2021');
    component.citaForm.controls.horaEntrada.setValue('06:00 AM');
    component.citaForm.controls.fechaSalida.setValue('04-01-2021');
    component.citaForm.controls.horaSalida.setValue('06:00 AM');
    component.citaForm.controls.valor.setValue(10000.0);    
    component.create();
    expect(component.citaForm.valid).toBeTruthy();    
    expect(component.message).toBeNull;
    expect(component.messageErro).not.toBeNull;
  }));

  it('Registrando la cita OK', async(() => {
    component.citaForm.controls.placaVehiculo.setValue('KIP058');
    component.citaForm.controls.idCliente.setValue('123456789');
    component.citaForm.controls.fechaEntrada.setValue('04-17-2021');
    component.citaForm.controls.horaEntrada.setValue('08:00 AM');
    component.citaForm.controls.fechaSalida.setValue('04-17-2021');
    component.citaForm.controls.horaSalida.setValue('09:00 AM');
    component.citaForm.controls.valor.setValue(10000.0);    
    component.create();
    expect(component.citaForm.valid).toBeTruthy    
    expect(component.message).toContain("Codigo de cita [");
    expect(component.messageErro).toBeNull;
  }));
});
