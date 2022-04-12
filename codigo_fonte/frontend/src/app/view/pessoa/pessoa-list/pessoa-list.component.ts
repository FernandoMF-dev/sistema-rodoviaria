import { Component, OnInit } from '@angular/core';
import { PageNotificationService } from '@nuvem/primeng-components';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { finalize } from 'rxjs/operators';
import { PessoaList } from '../models/pessoa-list.model';
import { Pessoa } from '../models/pessoa.model';
import { PessoaService } from '../services/pessoa.service';

@Component({
	selector: 'app-pessoa-list',
	templateUrl: './pessoa-list.component.html',
	styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

	@BlockUI() blockUI: NgBlockUI;

	pessoas: PessoaList[] = [];
	pessoaSelecionada: Pessoa;

	tableConfig = [
		{ header: 'Nome', field: ['nome', 'sobrenome'], compound: true },
		{ header: 'Data de Nascimento', field: 'dataNascimento', date: true },
		{ header: 'Telefone', field: 'telefone', text: true },
		{ header: 'Email', field: 'email', text: true }
	];

	constructor(
		private pessoaService: PessoaService,
		private pageNotificationService: PageNotificationService
	) {
	}

	buscarPessoas(): void {
		this.blockUI.start();
		this.pessoaService.findAll()
			.pipe(finalize(() => this.blockUI.stop()))
			.subscribe(
				(res) => this.pessoas = res,
				(err) => this.pageNotificationService.addErrorMessage(err.error.detail)
			);
	}

	ngOnInit(): void {
		this.buscarPessoas();
	}

}
