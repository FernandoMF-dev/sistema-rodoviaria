import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';

import { CobrancaViagemRoutingModule } from './cobranca-viagem-routing.module';


@NgModule({
	declarations: [],
	imports: [
		CommonModule,
		CobrancaViagemRoutingModule,
		SharedModule
	]
})
export class CobrancaViagemModule {
}
