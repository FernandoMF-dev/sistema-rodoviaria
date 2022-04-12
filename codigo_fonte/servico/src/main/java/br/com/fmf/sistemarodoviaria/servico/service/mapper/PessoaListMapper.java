package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Pessoa;
import br.com.fmf.sistemarodoviaria.servico.service.dto.PessoaListDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaListMapper extends EntityMapper<PessoaListDto, Pessoa> {
}
