package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Passe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PasseRepository extends JpaRepository<Passe, Long>, JpaSpecificationExecutor<Passe> {

	List<Passe> findPasseByExcluidoIsFalse();

	Optional<Passe> findByIdAndExcluidoIsFalse(Long id);

	@Modifying
	@Query("UPDATE Passe p SET p.excluido = TRUE WHERE p.id = :id")
	void delete(@Param("id") Long id);

}
