package br.com.fmf.sistemarodoviaria.servico.rest;

import br.com.fmf.sistemarodoviaria.servico.service.OnibusService;
import br.com.fmf.sistemarodoviaria.servico.service.dto.OnibusDto;
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
@RequestMapping("/api/onibus")
public class OnibusResource {

	private final OnibusService onibusService;

	@GetMapping
	public ResponseEntity<List<OnibusDto>> findAll() {
		return new ResponseEntity<>(onibusService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{onibusId}")
	public ResponseEntity<OnibusDto> findById(@PathVariable("onibusId") Long onibusId) {
		return new ResponseEntity<>(onibusService.findById(onibusId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<OnibusDto> insert(@RequestBody OnibusDto onibusDto) {
		return new ResponseEntity<>(onibusService.insert(onibusDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<OnibusDto> update(@RequestBody OnibusDto onibusDto) {
		return new ResponseEntity<>(onibusService.update(onibusDto), HttpStatus.OK);
	}

	@DeleteMapping("/{onibusId}")
	public ResponseEntity<Void> delete(@PathVariable("onibusId") Long onibusId) {
		onibusService.delete(onibusId);
		return ResponseEntity.noContent().build();
	}

}
