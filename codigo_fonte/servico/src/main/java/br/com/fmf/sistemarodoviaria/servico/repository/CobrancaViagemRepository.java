package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.CobrancaViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CobrancaViagemRepository extends JpaRepository<CobrancaViagem, Long>, JpaSpecificationExecutor<CobrancaViagem> {

	List<CobrancaViagem> findCobrancaViagemByExcluidoIsFalse();

	Optional<CobrancaViagem> findByIdAndExcluidoIsFalse(Long id);

	@Modifying
	@Query("UPDATE CobrancaViagem cv SET cv.excluido = TRUE WHERE cv.id = :id")
	void delete(@Param("id") Long id);

}
