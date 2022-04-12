import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { PessoaList } from '../models/pessoa-list.model';
import { Pessoa } from '../models/pessoa.model';

@Injectable({
	providedIn: 'root'
})
export class PessoaService {

	private readonly api = `${ environment.apiUrl }/pessoa`;

	constructor(private http: HttpClient) {
	}

	delete(pessoaId: number): Observable<void> {
		return this.http.delete<void>(`${ this.api }/${ pessoaId }`);
	}

	findAll(): Observable<PessoaList[]> {
		return this.http.get<PessoaList[]>(`${ this.api }`);
	}

	findById(pessoaId: number): Observable<Pessoa> {
		return this.http.get(`${ this.api }/${ pessoaId }`);
	}

	insert(pessoa: Pessoa): Observable<Pessoa> {
		return this.http.post(`${ this.api }`, pessoa);
	}

	update(pessoa: Pessoa): Observable<Pessoa> {
		return this.http.put(`${ this.api }`, pessoa);
	}
}
