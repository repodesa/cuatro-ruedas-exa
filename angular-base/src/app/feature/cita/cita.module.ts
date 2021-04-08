import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { ListarCitaComponent } from './components/listar-cita/listar-cita.component';
import { CrearCitaComponent } from './components/crear-cita/crear-cita.component';
import { CitaService } from './shared/service/cita.service';
import { CitaComponent } from './components/cita/cita.component';
import { CitaRoutingModule } from './cita-routing.module';


@NgModule({
  declarations: [
    CrearCitaComponent,
    ListarCitaComponent,    
    CitaComponent
  ],
  imports: [
    CitaRoutingModule,
    SharedModule
  ],
  providers: [CitaService]
})
export class CitaModule { }
