package br.com.fmf.sistemarodoviaria.servico.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TB_COBRANCA_VIAGEM")
public class CobrancaViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COBRANCA_VIAGEM")
	@SequenceGenerator(name = "SEQ_COBRANCA_VIAGEM", sequenceName = "SEQ_COBRANCA_VIAGEM", allocationSize = 1)
	@Column(name = "ID_COBRANCA_VIAGEM", nullable = false)
	private Long id;

	@Column(name = "DATA_HORA")
	private LocalDateTime dataHora;

	@Column(name = "VALOR", nullable = false)
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_PASSE", nullable = false)
	private Passe passe;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_ONIBUS", nullable = false)
	private Onibus onibus;

	@Column(name = "EXCLUIDO", nullable = false)
	private Boolean excluido;

}
