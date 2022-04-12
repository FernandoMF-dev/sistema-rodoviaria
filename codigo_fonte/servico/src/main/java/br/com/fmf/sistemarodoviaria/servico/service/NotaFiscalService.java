package br.com.fmf.sistemarodoviaria.servico.service;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.NotaFiscal;
import br.com.fmf.sistemarodoviaria.servico.repository.NotaFiscalRepository;
import br.com.fmf.sistemarodoviaria.servico.service.dto.NotaFiscalDto;
import br.com.fmf.sistemarodoviaria.servico.service.exception.RegraNegocioException;
import br.com.fmf.sistemarodoviaria.servico.service.mapper.NotaFiscalMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class NotaFiscalService {

	private final NotaFiscalMapper notaFiscalMapper;
	private final NotaFiscalRepository notaFiscalRepository;


	public NotaFiscalDto insert(NotaFiscalDto dto) {
		NotaFiscal entity = notaFiscalMapper.toEntity(dto);

		entity.setId(null);
		entity.setExcluido(false);

		return save(entity);
	}

	public NotaFiscalDto update(NotaFiscalDto dto) {
		NotaFiscal entity = notaFiscalMapper.toEntity(dto);

		entity.setExcluido(false);

		return save(entity);
	}

	public List<NotaFiscalDto> findAll() {
		return notaFiscalMapper.toDto(notaFiscalRepository.findNotaFiscalByExcluidoIsFalse());
	}

	public NotaFiscalDto findById(Long id) {
		return notaFiscalMapper.toDto(notaFiscalRepository.findByIdAndExcluidoIsFalse(id)
				.orElseThrow(() -> new RegraNegocioException("Registro não encontrado")));
	}

	public void delete(Long id) {
		notaFiscalRepository.delete(id);
	}

	private NotaFiscalDto save(NotaFiscal entity) {
		return notaFiscalMapper.toDto(notaFiscalRepository.save(entity));
	}


}
