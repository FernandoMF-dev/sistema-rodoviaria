import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';

import { OnibusRoutingModule } from './onibus-routing.module';


@NgModule({
	declarations: [],
	imports: [
		CommonModule,
		OnibusRoutingModule,
		SharedModule
	]
})
export class OnibusModule {
}
