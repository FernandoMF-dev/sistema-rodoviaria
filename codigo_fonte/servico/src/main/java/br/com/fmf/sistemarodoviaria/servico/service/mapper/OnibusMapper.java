package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Onibus;
import br.com.fmf.sistemarodoviaria.servico.service.dto.OnibusDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OnibusMapper extends EntityMapper<OnibusDto, Onibus> {
}
