package br.com.fmf.sistemarodoviaria.servico.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ArquivoDto implements Serializable {

	private UUID uuid;
	private String nome;
	private String mimeType;
	private LocalDateTime dataUpload;
	private Long tamanhoBytes;

	private byte[] file;

}
