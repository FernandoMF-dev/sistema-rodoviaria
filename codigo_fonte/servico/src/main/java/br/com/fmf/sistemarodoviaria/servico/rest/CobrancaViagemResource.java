package br.com.fmf.sistemarodoviaria.servico.rest;

import br.com.fmf.sistemarodoviaria.servico.service.CobrancaViagemService;
import br.com.fmf.sistemarodoviaria.servico.service.dto.CobrancaViagemDto;
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
@RequestMapping("/api/cobranca")
public class CobrancaViagemResource {

	private final CobrancaViagemService cobrancaViagemService;

	@GetMapping
	public ResponseEntity<List<CobrancaViagemDto>> findAll() {
		return new ResponseEntity<>(cobrancaViagemService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{cobrancaViagemId}")
	public ResponseEntity<CobrancaViagemDto> findById(@PathVariable("cobrancaViagemId") Long cobrancaViagemId) {
		return new ResponseEntity<>(cobrancaViagemService.findById(cobrancaViagemId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CobrancaViagemDto> insert(@RequestBody CobrancaViagemDto cobrancaViagemDto) {
		return new ResponseEntity<>(cobrancaViagemService.insert(cobrancaViagemDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<CobrancaViagemDto> update(@RequestBody CobrancaViagemDto cobrancaViagemDto) {
		return new ResponseEntity<>(cobrancaViagemService.update(cobrancaViagemDto), HttpStatus.OK);
	}

	@DeleteMapping("/{cobrancaViagemId}")
	public ResponseEntity<Void> delete(@PathVariable("cobrancaViagemId") Long cobrancaViagemId) {
		cobrancaViagemService.delete(cobrancaViagemId);
		return ResponseEntity.noContent().build();
	}

}
