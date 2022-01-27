package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, JpaSpecificationExecutor<Pessoa> {

	List<Pessoa> findPessoaByExcluidoIsFalse();

	Optional<Pessoa> findByIdAndExcluidoIsFalse(Long id);

	@Modifying
	@Query("UPDATE Pessoa p SET p.excluido = TRUE WHERE p.id = :id")
	void delete(@Param("id") Long id);
}
