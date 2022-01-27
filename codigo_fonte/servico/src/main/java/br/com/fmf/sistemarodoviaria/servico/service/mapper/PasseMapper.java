package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Passe;
import br.com.fmf.sistemarodoviaria.servico.domain.entity.Pessoa;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PasseDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Objects;

@Mapper(componentModel = "spring", uses = {PessoaMapper.class})
public interface PasseMapper extends EntityMapper<PasseDto, Passe> {

	@Override
	@Mapping(target = "pessoaId", source = "pessoa.id")
	PasseDto toDto(Passe entity);

	@AfterMapping
	default void mapPessoaToEntity(@MappingTarget Passe entity, PasseDto dto) {
		if (Objects.isNull(dto.getPessoa()) && Objects.nonNull(dto.getPessoaId())) {
			Pessoa pessoa = new Pessoa();

			pessoa.setId(dto.getPessoaId());
		}
	}

}
