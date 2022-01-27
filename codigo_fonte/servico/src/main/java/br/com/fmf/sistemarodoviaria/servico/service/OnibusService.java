package br.com.fmf.sistemarodoviaria.servico.service;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Onibus;
import br.com.fmf.sistemarodoviaria.servico.repository.OnibusRepository;
import br.com.fmf.sistemarodoviaria.servico.service.dto.OnibusDto;
import br.com.fmf.sistemarodoviaria.servico.service.exception.RegraNegocioException;
import br.com.fmf.sistemarodoviaria.servico.service.mapper.OnibusMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class OnibusService {

	private final OnibusMapper onibusMapper;
	private final OnibusRepository onibusRepository;

	public OnibusDto insert(OnibusDto dto) {
		Onibus entity = onibusMapper.toEntity(dto);

		entity.setId(null);
		entity.setExcluido(false);

		return save(entity);
	}

	public OnibusDto update(OnibusDto dto) {
		Onibus entity = onibusMapper.toEntity(dto);

		entity.setExcluido(false);

		return save(entity);
	}

	public List<OnibusDto> findAll() {
		return onibusMapper.toDto(onibusRepository.findOnibusByExcluidoIsFalse());
	}

	public OnibusDto findById(Long id) {
		return onibusMapper.toDto(onibusRepository.findByIdAndExcluidoIsFalse(id)
				.orElseThrow(() -> new RegraNegocioException("Registro não encontrado")));
	}

	public void delete(Long id) {
		onibusRepository.delete(id);
	}

	private OnibusDto save(Onibus entity) {
		return onibusMapper.toDto(onibusRepository.save(entity));
	}

}
