package br.com.fmf.sistemarodoviaria.documento.service;

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MinioService {

	private final MinioClient minioClient;

}
