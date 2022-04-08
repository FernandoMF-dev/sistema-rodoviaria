package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Arquivo;
import br.com.fmf.sistemarodoviaria.servico.service.dto.ArquivoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArquivoMapper extends EntityMapper<ArquivoDto, Arquivo> {
}
