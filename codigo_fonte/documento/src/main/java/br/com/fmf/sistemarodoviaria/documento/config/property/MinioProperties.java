package br.com.fmf.sistemarodoviaria.documento.config.property;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinioProperties {
	private String url;
	private String bucket;
	private String accessKey;
	private String secretKey;
}
