package br.com.fmf.sistemarodoviaria.servico.service;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Passe;
import br.com.fmf.sistemarodoviaria.servico.repository.PasseRepository;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PasseDto;
import br.com.fmf.sistemarodoviaria.servico.service.exception.RegraNegocioException;
import br.com.fmf.sistemarodoviaria.servico.service.mapper.PasseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class PasseService {

	private final PasseMapper passeMapper;
	private final PasseRepository passeRepository;

	public PasseDto insert(PasseDto dto) {
		Passe entity = passeMapper.toEntity(dto);

		entity.setId(null);
		entity.setExcluido(false);

		return save(entity);
	}

	public PasseDto update(PasseDto dto) {
		Passe entity = passeMapper.toEntity(dto);
		return save(entity);
	}

	public List<PasseDto> findAll() {
		return passeMapper.toDto(passeRepository.findPasseByExcluidoIsFalse());
	}

	public PasseDto findById(Long id) {
		return passeMapper.toDto(passeRepository.findByIdAndExcluidoIsFalse(id)
				.orElseThrow(() -> new RegraNegocioException("Registro não encontrado")));
	}

	public void delete(Long id) {
		passeRepository.delete(id);
	}

	private PasseDto save(Passe entity) {
		return passeMapper.toDto(passeRepository.save(entity));
	}

}
