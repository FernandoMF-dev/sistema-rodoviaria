import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { UrlEnum } from './shared/enums/url.enum';

const routes: Routes = [
	{
		path: UrlEnum.DIARIO_ERROS,
		component: DiarioErrosComponent,
		data: { breadcrumb: 'Diário de Erros' }
	},
	{
		path: UrlEnum.LOGIN_SUCCESS,
		component: LoginSuccessComponent
	},
	{
		path: UrlEnum.PESSOA,
		loadChildren: './view/pessoa/pessoa.module#PessoaModule',
		data: { breadcrumb: 'Pessoa' }
	}
];

@NgModule({
	imports: [
		RouterModule.forRoot(routes)
	],
	exports: [RouterModule]
})
export class AppRoutingModule {
}
