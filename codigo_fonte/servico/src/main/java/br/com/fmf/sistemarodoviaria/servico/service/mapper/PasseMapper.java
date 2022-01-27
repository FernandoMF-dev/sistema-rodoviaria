package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Passe;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PasseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PasseMapper extends EntityMapper<PasseDto, Passe> {
}
