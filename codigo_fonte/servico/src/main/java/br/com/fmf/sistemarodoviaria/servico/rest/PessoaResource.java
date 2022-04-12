package br.com.fmf.sistemarodoviaria.servico.rest;

import br.com.fmf.sistemarodoviaria.servico.service.PessoaService;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PessoaDto;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PessoaListDto;
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
@RequestMapping("/api/pessoa")
public class PessoaResource {

	private final PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<PessoaListDto>> findAll() {
		return new ResponseEntity<>(pessoaService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{pessoaId}")
	public ResponseEntity<PessoaDto> findById(@PathVariable("pessoaId") Long pessoaId) {
		return new ResponseEntity<>(pessoaService.findById(pessoaId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PessoaDto> insert(@RequestBody PessoaDto pessoaDto) {
		return new ResponseEntity<>(pessoaService.insert(pessoaDto), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<PessoaDto> update(@RequestBody PessoaDto pessoaDto) {
		return new ResponseEntity<>(pessoaService.update(pessoaDto), HttpStatus.OK);
	}

	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Void> delete(@PathVariable("pessoaId") Long pessoaId) {
		pessoaService.delete(pessoaId);
		return ResponseEntity.noContent().build();
	}
}
