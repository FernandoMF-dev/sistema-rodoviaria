package br.com.fmf.sistemarodoviaria.servico.rest;

import br.com.fmf.sistemarodoviaria.servico.service.ArquivoService;
import br.com.fmf.sistemarodoviaria.servico.service.dto.ArquivoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/arquivo")
public class ArquivoResource {

	private final ArquivoService anexoService;

	@PostMapping
	public ResponseEntity<ArquivoDto> create(@RequestParam String diretorio, @RequestBody MultipartFile file) {
		log.debug("Requisição rest para criação de um arquivo {}.{}", file.getName(), file.getContentType());
		anexoService.save(file);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/api/{diretorio}")
				.buildAndExpand(diretorio)
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
		log.debug("Requisição rest para excluir um arquivo com o uuid: {}", uuid);
		anexoService.deleteByUuid(uuid);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<ArquivoDto> find(@PathVariable UUID uuid) {
		log.debug("Requisição rest para buscar o arquivo com o uuid: {}", uuid);
		return ResponseEntity.ok(anexoService.findByUuid(uuid));
	}

}
