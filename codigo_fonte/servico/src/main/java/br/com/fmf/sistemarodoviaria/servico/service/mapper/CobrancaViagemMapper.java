package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.CobrancaViagem;
import br.com.fmf.sistemarodoviaria.servico.service.dto.CobrancaViagemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CobrancaViagemMapper extends EntityMapper<CobrancaViagemDto, CobrancaViagem> {
}
