package br.com.fmf.sistemarodoviaria.servico.service.mapper;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.NotaFiscal;
import br.com.fmf.sistemarodoviaria.servico.service.dto.NotaFiscalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CobrancaViagemMapper.class, ArquivoMapper.class})
public interface NotaFiscalMapper extends EntityMapper<NotaFiscalDto, NotaFiscal> {
}
