package br.com.fmf.sistemarodoviaria.servico.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_ARQUIVO")
public class Arquivo implements Serializable {

	@Id
	@Column(name = "UUID", nullable = false)
	private UUID uuid;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "MIME_TYPE", nullable = false, length = 30)
	private String mimeType;

	@Column(name = "DATA_UPLOAD", nullable = false)
	private LocalDateTime dataUpload;

	@Column(name = "TAMANHO_BYTES", nullable = false)
	private Long tamanhoBytes;

	@Column(name = "EXCLUIDO", nullable = false)
	private Boolean excluido = Boolean.FALSE;

}
