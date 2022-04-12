import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { PessoaRoutingModule } from './pessoa-routing.module';
import { PessoaComponent } from './pessoa.component';


@NgModule({
	declarations: [PessoaComponent],
	imports: [
		CommonModule,
		PessoaRoutingModule
	]
})
export class PessoaModule {
}
