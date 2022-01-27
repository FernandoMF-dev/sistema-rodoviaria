package br.com.fmf.sistemarodoviaria.servico.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDto implements Serializable {
	private Long id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
}
