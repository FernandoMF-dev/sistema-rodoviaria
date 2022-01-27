package br.com.fmf.sistemarodoviaria.servico.domain.entity;

import br.com.fmf.sistemarodoviaria.servico.domain.enums.CategoriaPasseEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "TB_PASSE")
public class Passe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SEQ_PASSE", sequenceName = "SEQ_PASSE", allocationSize = 1)
	@Column(name = "ID_PASSE", nullable = false)
	private Long id;

	@Column(name = "RFID", nullable = false)
	private Long rfid;

	@Column(name = "SALDO", nullable = false)
	private Double saldo;

	@Column(name = "ATIVO", nullable = false)
	private Boolean ativo;

	@Enumerated(EnumType.STRING)
	@Column(name = "CATEGORIA", nullable = false)
	private CategoriaPasseEnum categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PESSOA", nullable = false)
	private Pessoa pessoa;

	@Column(name = "EXCLUIDO", nullable = false)
	private Boolean excluido;

}
