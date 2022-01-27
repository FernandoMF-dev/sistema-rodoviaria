package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.CobrancaViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CobrancaViagemRepository extends JpaRepository<CobrancaViagem, Long>, JpaSpecificationExecutor<CobrancaViagem> {
}
