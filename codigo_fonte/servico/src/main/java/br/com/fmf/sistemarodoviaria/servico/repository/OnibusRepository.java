package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OnibusRepository extends JpaRepository<Onibus, Long>, JpaSpecificationExecutor<Onibus> {
}
