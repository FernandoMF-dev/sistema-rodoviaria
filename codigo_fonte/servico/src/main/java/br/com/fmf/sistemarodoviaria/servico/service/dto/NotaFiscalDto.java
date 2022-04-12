package br.com.fmf.sistemarodoviaria.servico.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotaFiscalDto implements Serializable {

	private Long id;
	private CobrancaViagemDto cobranca;
	private ArquivoDto arquivo;
}
