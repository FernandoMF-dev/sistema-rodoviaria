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
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PESSOA")
@Getter
@Setter
public class Pessoa implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
	@SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NOME", nullable = false, length = 100)
	private String nome;

	@Column(name = "SOBRENOME", nullable = false, length = 100)
	private String sobrenome;

	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "CIDADE", nullable = false, length = 100)
	private String cidade;

	@Column(name = "ESTADO", nullable = false, length = 2)
	private String estado;

	@Column(name = "TELEFONE", length = 20)
	private String telefone;

	@Column(name = "EMAIL", length = 200)
	private String email;

}
