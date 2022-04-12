import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { PessoaListComponent } from './pessoa-list/pessoa-list.component';

import { PessoaRoutingModule } from './pessoa-routing.module';
import { PessoaComponent } from './pessoa.component';


@NgModule({
	declarations: [PessoaComponent, PessoaListComponent],
	imports: [
		CommonModule,
		PessoaRoutingModule
	]
})
export class PessoaModule {
}
