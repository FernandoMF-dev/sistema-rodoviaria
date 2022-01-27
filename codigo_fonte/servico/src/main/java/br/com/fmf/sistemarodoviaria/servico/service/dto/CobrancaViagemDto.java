package br.com.fmf.sistemarodoviaria.servico.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CobrancaViagemDto implements Serializable {
	private Long id;
	private LocalDateTime dataHora;
	private Double valor;
	private Long passeId;
	private Long onibusId;

	private PasseDto passe;
	private OnibusDto onibus;
}
