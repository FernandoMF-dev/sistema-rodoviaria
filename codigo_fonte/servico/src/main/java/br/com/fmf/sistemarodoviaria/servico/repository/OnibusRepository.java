package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OnibusRepository extends JpaRepository<Onibus, Long>, JpaSpecificationExecutor<Onibus> {

	List<Onibus> findOnibusByExcluidoIsFalse();

	Optional<Onibus> findByIdAndExcluidoIsFalse(Long id);

	@Modifying
	@Query("UPDATE Onibus o SET o.excluido = TRUE WHERE o.id = :id")
	void delete(@Param("id") Long id);

}
