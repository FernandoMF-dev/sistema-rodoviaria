package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Passe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PasseRepository extends JpaRepository<Passe, Long>, JpaSpecificationExecutor<Passe> {
}