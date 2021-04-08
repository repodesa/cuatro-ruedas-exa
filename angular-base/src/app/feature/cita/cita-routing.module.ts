import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CitaComponent } from './components/cita/cita.component';
import { CrearCitaComponent } from './components/crear-cita/crear-cita.component';
import { ListarCitaComponent } from './components/listar-cita/listar-cita.component';

const routes: Routes = [
  {
    path: '',
    component: CitaComponent,
    children: [
      {
        path: 'crear',
        component: CrearCitaComponent
      },
      {
        path: 'listar',
        component: ListarCitaComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CitaRoutingModule { }
