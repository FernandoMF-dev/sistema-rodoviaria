package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Pessoa;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PessoaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper extends EntityMapper<PessoaDto, Pessoa> {
}
