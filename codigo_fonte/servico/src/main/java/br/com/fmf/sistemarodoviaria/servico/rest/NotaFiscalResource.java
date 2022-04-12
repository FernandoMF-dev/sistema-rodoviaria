package br.com.fmf.sistemarodoviaria.servico.rest;

import br.com.fmf.sistemarodoviaria.servico.service.NotaFiscalService;
import br.com.fmf.sistemarodoviaria.servico.service.dto.NotaFiscalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nota-fiscal")
public class NotaFiscalResource {

	private final NotaFiscalService notaFiscalService;

	@GetMapping
	public ResponseEntity<List<NotaFiscalDto>> findAll() {
		return new ResponseEntity<>(notaFiscalService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{notaFiscalId}")
	public ResponseEntity<NotaFiscalDto> findById(@PathVariable("notaFiscalId") Long notaFiscalId) {
		return new ResponseEntity<>(notaFiscalService.findById(notaFiscalId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<NotaFiscalDto> insert(@RequestBody NotaFiscalDto notaFiscalDto) {
		return new ResponseEntity<>(notaFiscalService.insert(notaFiscalDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<NotaFiscalDto> update(@RequestBody NotaFiscalDto notaFiscalDto) {
		return new ResponseEntity<>(notaFiscalService.update(notaFiscalDto), HttpStatus.OK);
	}

	@DeleteMapping("/{notaFiscalId}")
	public ResponseEntity<Void> delete(@PathVariable("notaFiscalId") Long notaFiscalId) {
		notaFiscalService.delete(notaFiscalId);
		return ResponseEntity.noContent().build();
	}
}
