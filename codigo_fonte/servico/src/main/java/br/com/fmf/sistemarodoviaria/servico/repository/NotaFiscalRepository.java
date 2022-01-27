package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>, JpaSpecificationExecutor<NotaFiscal> {
}
