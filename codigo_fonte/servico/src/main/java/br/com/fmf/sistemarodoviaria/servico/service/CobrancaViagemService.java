package br.com.fmf.sistemarodoviaria.servico.service;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.CobrancaViagem;
import br.com.fmf.sistemarodoviaria.servico.repository.CobrancaViagemRepository;
import br.com.fmf.sistemarodoviaria.servico.service.dto.CobrancaViagemDto;
import br.com.fmf.sistemarodoviaria.servico.service.exception.RegraNegocioException;
import br.com.fmf.sistemarodoviaria.servico.service.mapper.CobrancaViagemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class CobrancaViagemService {

	private final CobrancaViagemMapper cobrancaViagemMapper;
	private final CobrancaViagemRepository cobrancaViagemRepository;

	public CobrancaViagemDto insert(CobrancaViagemDto dto) {
		CobrancaViagem entity = cobrancaViagemMapper.toEntity(dto);

		entity.setId(null);
		entity.setExcluido(false);
		entity.setDataHora(LocalDateTime.now());

		return save(entity);
	}

	public CobrancaViagemDto update(CobrancaViagemDto dto) {
		CobrancaViagem entity = cobrancaViagemMapper.toEntity(dto);

		entity.setExcluido(false);

		return save(entity);
	}

	public List<CobrancaViagemDto> findAll() {
		return cobrancaViagemMapper.toDto(cobrancaViagemRepository.findCobrancaViagemByExcluidoIsFalse());
	}

	public CobrancaViagemDto findById(Long id) {
		return cobrancaViagemMapper.toDto(cobrancaViagemRepository.findByIdAndExcluidoIsFalse(id)
				.orElseThrow(() -> new RegraNegocioException("Registro não encontrado")));
	}

	public void delete(Long id) {
		cobrancaViagemRepository.delete(id);
	}

	private CobrancaViagemDto save(CobrancaViagem entity) {
		return cobrancaViagemMapper.toDto(cobrancaViagemRepository.save(entity));
	}

}
