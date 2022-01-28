package br.com.fmf.sistemarodoviaria.documento.config;

import br.com.fmf.sistemarodoviaria.documento.config.property.ApplicationProperties;
import br.com.fmf.sistemarodoviaria.documento.config.property.MinioProperties;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MinioConfig {

	private final ApplicationProperties applicationProperties;

	@Bean
	public MinioClient minioClient() {
		MinioProperties minioProperties = applicationProperties.getMinio();
		MinioClient minioClient = MinioClient.builder()
				.endpoint(minioProperties.getUrl())
				.credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
				.build();
		createBucket(minioClient);

		return minioClient;
	}

	@SneakyThrows
	private void createBucket(MinioClient minioClient) {
		MinioProperties minioProperties = applicationProperties.getMinio();

		if (!bucketExists(minioClient, minioProperties.getBucket())) {
			minioClient.makeBucket(MakeBucketArgs.builder()
					.bucket(minioProperties.getBucket())
					.build());
		}
	}

	@SneakyThrows
	private boolean bucketExists(MinioClient minioClient, String bucketName) {
		return minioClient.bucketExists(BucketExistsArgs.builder()
				.bucket(bucketName)
				.build());
	}

}
