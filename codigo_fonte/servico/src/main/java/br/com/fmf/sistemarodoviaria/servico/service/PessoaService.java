package br.com.fmf.sistemarodoviaria.servico.service;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Pessoa;
import br.com.fmf.sistemarodoviaria.servico.repository.PessoaRepository;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PessoaDto;
import br.com.fmf.sistemarodoviaria.servico.service.exception.RegraNegocioException;
import br.com.fmf.sistemarodoviaria.servico.service.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class PessoaService {

	private final PessoaMapper pessoaMapper;
	private final PessoaRepository pessoaRepository;

	public PessoaDto insert(PessoaDto dto) {
		Pessoa entity = pessoaMapper.toEntity(dto);

		entity.setId(null);
		entity.setExcluido(false);

		return save(entity);
	}

	public PessoaDto update(PessoaDto dto) {
		Pessoa entity = pessoaMapper.toEntity(dto);
		return save(entity);
	}

	public List<PessoaDto> findAll() {
		return pessoaMapper.toDto(pessoaRepository.findPessoaByExcluidoIsFalse());
	}

	public PessoaDto findById(Long id) {
		return pessoaMapper.toDto(pessoaRepository.findByIdAndExcluidoIsFalse(id)
				.orElseThrow(() -> new RegraNegocioException("Registro não encontrado")));
	}

	public void delete(Long id) {
		pessoaRepository.delete(id);
	}

	private PessoaDto save(Pessoa entity) {
		return pessoaMapper.toDto(pessoaRepository.save(entity));
	}

}
