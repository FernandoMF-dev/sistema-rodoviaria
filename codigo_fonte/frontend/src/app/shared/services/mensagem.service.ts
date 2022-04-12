import { Injectable } from '@angular/core';
import { Confirmation, ConfirmationService } from 'primeng';
import { MensagemEnum } from '../enums/mensagem.enum';

@Injectable({
	providedIn: 'root'
})
export class MensagemService {

	constructor(
		private confirmationService: ConfirmationService
	) {
	}


	private static montarConfirmationBase(titulo: string, mensagem: string, icon: string = 'pi pi-exclamation-triangle'): Confirmation {
		return {
			message: mensagem,
			header: titulo,
			icon: icon,
			acceptLabel: MensagemEnum.OK,
			rejectVisible: false,
			acceptVisible: true
		};
	}

	exibirMensagem(titulo: string, mensagem: string, componente?: Object, accept?: (...args) => void, reject?: (...args) => void): void {
		const confirmation: Confirmation = MensagemService.montarConfirmationBase(titulo, mensagem);

		if (accept) {
			confirmation.acceptLabel = MensagemEnum.SIM;
			confirmation.rejectLabel = MensagemEnum.NAO;
			confirmation.rejectVisible = true;
			confirmation.accept = () => accept.bind(componente)();

			if (reject) {
				confirmation.reject = () => reject.bind(componente)();
			}
		}

		this.confirmationService.confirm(confirmation);
	}

	exibirPopup(titulo: string, mensagem: string, componente?: Object, action?: (...args) => void): void {
		const confirmation: Confirmation = MensagemService.montarConfirmationBase(titulo, mensagem);

		if (action) {
			confirmation.accept = () => action.bind(componente)();
		}

		this.confirmationService.confirm(confirmation);
	}

}
