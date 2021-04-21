import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { CitaComponent } from './cita.component';

describe('CitaComponent', () => {
  let component: CitaComponent;
  let fixture: ComponentFixture<CitaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CitaComponent ],
      imports: [CommonModule, 
                HttpClientModule, 
                RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CitaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('debería crear el componente cita ', () => {
    expect(component).toBeTruthy();
  });

  it('Deberia validar los titulos de componentes',async(() =>{
    /*De esta manera se obtiene el valor del artefacto Html*/
    const ficture = TestBed.createComponent(CitaComponent);
    ficture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('a').textContent).toContain('Inicio');

    /*De esta manera se obtiene el valor del artefacto Html por el ID */
    expect((<HTMLInputElement>document.getElementById('linkCita')).textContent).toEqual('Inicio');
    expect((<HTMLInputElement>document.getElementById('linkListarCitas')).textContent).toEqual(' Listar ');
    expect((<HTMLInputElement>document.getElementById('linkCrearCita')).textContent).toEqual(' Crear ');
  }));
});
