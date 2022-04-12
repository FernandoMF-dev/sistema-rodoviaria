import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';

import { PasseRoutingModule } from './passe-routing.module';


@NgModule({
	declarations: [],
	imports: [
		CommonModule,
		PasseRoutingModule,
		SharedModule
	]
})
export class PasseModule {
}
