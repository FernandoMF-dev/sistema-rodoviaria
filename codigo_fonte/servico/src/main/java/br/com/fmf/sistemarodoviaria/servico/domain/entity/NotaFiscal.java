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
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "TB_NOTA_FISCAL")
public class NotaFiscal implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_NOTA_FISCAL")
	@SequenceGenerator(name = "SEQ_NOTA_FISCAL", sequenceName = "SEQ_NOTA_FISCAL", allocationSize = 1)
	@Column(name = "ID_NOTA_FISCAL", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ID_COBRANCA_VIAGEM", nullable = false)
	private CobrancaViagem cobranca;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "UUID_ARQUIVO", nullable = false)
	private Arquivo arquivo;

	@Column(name = "EXCLUIDO", nullable = false)
	private Boolean excluido;

}
