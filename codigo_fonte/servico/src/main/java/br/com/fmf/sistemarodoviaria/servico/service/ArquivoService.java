package br.com.fmf.sistemarodoviaria.servico.service;

import br.com.fmf.sistemarodoviaria.servico.repository.ArquivoRepository;
import br.com.fmf.sistemarodoviaria.servico.service.dto.ArquivoDto;
import br.com.fmf.sistemarodoviaria.servico.service.feign.DocumentoClient;
import br.com.fmf.sistemarodoviaria.servico.service.mapper.ArquivoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ArquivoService {

	private final ArquivoMapper arquivoMapper;
	private final ArquivoRepository arquivoRepository;

	private final DocumentoClient documentoClient;

	public void deleteByUuid(UUID uuid) {
		documentoClient.delete(uuid);
		arquivoRepository.deleteById(uuid);
	}

	public ArquivoDto findByUuid(UUID uuid) {
		return arquivoRepository.findById(uuid)
				.map(entity -> {
					ArquivoDto dto = arquivoMapper.toDto(entity);
					dto.setFile(documentoClient.find(uuid));
					return dto;
				})
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "O registro não foi encontrado"));
	}

	public void save(MultipartFile file) {
		UUID uuid = documentoClient.create(file);

		ArquivoDto dto = ArquivoDto.builder()
				.uuid(uuid)
				.nome(file.getOriginalFilename())
				.mimeType(file.getContentType())
				.tamanhoBytes(file.getSize())
				.dataUpload(LocalDateTime.now())
				.build();

		arquivoRepository.save(arquivoMapper.toEntity(dto));
	}
}
