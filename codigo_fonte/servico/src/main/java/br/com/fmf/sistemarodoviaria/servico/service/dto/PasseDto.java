package br.com.fmf.sistemarodoviaria.servico.service.dto;

import br.com.fmf.sistemarodoviaria.servico.domain.enums.CategoriaPasseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PasseDto implements Serializable {
	private Long id;
	private Long rfid;
	private Double saldo;
	private Boolean ativo;
	private CategoriaPasseEnum categoria;
	private Long pessoaId;

	private PessoaDto pessoa;
}
