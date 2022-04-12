package br.com.fmf.sistemarodoviaria.servico.repository;

import br.com.fmf.sistemarodoviaria.servico.domain.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>, JpaSpecificationExecutor<NotaFiscal> {

	List<NotaFiscal> findNotaFiscalByExcluidoIsFalse();

	Optional<NotaFiscal> findByIdAndExcluidoIsFalse(Long id);

	@Modifying
	@Query("UPDATE NotaFiscal nf SET nf.excluido = TRUE WHERE nf.id = :id")
	void delete(@Param("id") Long id);

}
