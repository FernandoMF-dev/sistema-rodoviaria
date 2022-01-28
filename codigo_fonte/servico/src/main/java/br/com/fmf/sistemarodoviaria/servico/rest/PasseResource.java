package br.com.fmf.sistemarodoviaria.servico.rest;

import br.com.fmf.sistemarodoviaria.servico.service.PasseService;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PasseDto;
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
@RequestMapping("/api/passe")
public class PasseResource {

	private final PasseService passeService;

	@GetMapping
	public ResponseEntity<List<PasseDto>> findAll() {
		return new ResponseEntity<>(passeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{passeId}")
	public ResponseEntity<PasseDto> findById(@PathVariable("passeId") Long passeId) {
		return new ResponseEntity<>(passeService.findById(passeId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PasseDto> insert(@RequestBody PasseDto passeDto) {
		return new ResponseEntity<>(passeService.insert(passeDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<PasseDto> update(@RequestBody PasseDto passeDto) {
		return new ResponseEntity<>(passeService.update(passeDto), HttpStatus.OK);
	}

	@DeleteMapping("/{passeId}")
	public ResponseEntity<Void> delete(@PathVariable("passeId") Long passeId) {
		passeService.delete(passeId);
		return ResponseEntity.noContent().build();
	}

}
