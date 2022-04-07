package br.com.fmf.sistemarodoviaria.documento.rest;

import br.com.fmf.sistemarodoviaria.documento.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/documento")
public class DocumentoResource {

	private final DocumentoService documentoService;

	@PostMapping
	public ResponseEntity<UUID> create(@RequestBody MultipartFile file) {
		log.debug("Request so save file named {}", file.getName());
		return ResponseEntity.ok(documentoService.save(file));
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<Void> delete(@PathVariable UUID uuid) {
		log.debug("Request to delete file {}", uuid);
		documentoService.deleteByUuid(uuid);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<byte[]> find(@PathVariable UUID uuid) {
		log.debug("Request to find file {}", uuid);
		return ResponseEntity.ok(documentoService.findByUuid(uuid));
	}

}
