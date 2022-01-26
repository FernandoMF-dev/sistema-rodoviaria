package br.com.fmf.sistemarodoviaria.servico.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "TB_ONIBUS")
public class Onibus {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_ONIBUS", sequenceName = "SEQ_ONIBUS", allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "CIDADE", nullable = false, length = 50)
	private String cidade;

	@Column(name = "ESTADO", nullable = false, length = 2)
	private String estado;

	@Column(name = "NOME_LINHA", nullable = false, length = 100)
	private String nomeLinha;

	@Column(name = "INICIO_CIRCULACAO")
	private LocalTime inicioCirculacao;

	@Column(name = "FIM_CIRCULACAO")
	private LocalTime fimCirculacao;

}