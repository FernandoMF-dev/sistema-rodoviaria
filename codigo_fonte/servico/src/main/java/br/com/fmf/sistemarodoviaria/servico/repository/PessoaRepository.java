package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa> {
}
