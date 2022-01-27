package br.com.fmf.sistemarodoviaria.servico.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OnibusDto implements Serializable {
	private Long id;
	private String cidade;
	private String estado;
	private String nomeLinha;
	private LocalTime inicioCirculacao;
	private LocalTime fimCirculacao;
}
