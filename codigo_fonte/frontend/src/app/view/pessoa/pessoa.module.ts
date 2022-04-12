import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { PessoaCadastroComponent } from './pessoa-cadastro/pessoa-cadastro.component';
import { PessoaListComponent } from './pessoa-list/pessoa-list.component';

import { PessoaRoutingModule } from './pessoa-routing.module';
import { PessoaComponent } from './pessoa.component';


@NgModule({
	declarations: [PessoaComponent, PessoaListComponent, PessoaCadastroComponent],
	imports: [
		CommonModule,
		PessoaRoutingModule,
		SharedModule
	]
})
export class PessoaModule {
}
