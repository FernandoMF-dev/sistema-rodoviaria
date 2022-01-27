package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.CobrancaViagem;
import br.com.fmf.sistemarodoviaria.servico.domain.entity.Onibus;
import br.com.fmf.sistemarodoviaria.servico.domain.entity.Passe;
import br.com.fmf.sistemarodoviaria.servico.service.dto.CobrancaViagemDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {PasseMapper.class, OnibusMapper.class})
public interface CobrancaViagemMapper extends EntityMapper<CobrancaViagemDto, CobrancaViagem> {

	@Override
	@Mapping(target = "passeId", source = "passe.id")
	@Mapping(target = "onibusId", source = "onibus.id")
	CobrancaViagemDto toDto(CobrancaViagem entity);

	@AfterMapping
	default void mapPasseToEntity(@MappingTarget CobrancaViagem entity, CobrancaViagemDto dto) {
		if (Objects.isNull(dto.getPasseId())) {
			entity.setPasse(new Passe());
		}

		if (Objects.nonNull(dto.getPasseId())) {
			entity.getPasse().setId(dto.getPasseId());
		}
	}

	@AfterMapping
	default void mapOnibusToEntity(@MappingTarget CobrancaViagem entity, CobrancaViagemDto dto) {
		if (Objects.isNull(dto.getOnibusId())) {
			entity.setOnibus(new Onibus());
		}

		if (Objects.nonNull(dto.getOnibusId())) {
			entity.getOnibus().setId(dto.getOnibusId());
		}
	}

}
