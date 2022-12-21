package br.com.banco.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.banco.model.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {	
	
	@Query("SELECT tr FROM Transferencia tr WHERE (tr.conta.id = :idConta) AND (tr.dataTransferencia BETWEEN :min AND :max)")
	List<Transferencia> findTransferencias(LocalDate min, LocalDate max, Long idConta);
	
	@Query("SELECT tr FROM Transferencia tr WHERE (tr.conta.id = :idConta) "
			+ "AND (tr.dataTransferencia BETWEEN :min AND :max) "
			+ "AND (tr.nomeOperadorTransacao = :nomeOperador)")
	List<Transferencia> findTransferenciasComOperador(LocalDate min, LocalDate max, String nomeOperador, Long idConta);

	@Query("SELECT tr FROM Transferencia tr WHERE (tr.conta.id = :idConta)")
	List<Transferencia> findTodasTransferencias(Long idConta);
	
	@Query("SELECT tr.valor FROM Transferencia tr WHERE (tr.conta.id = :idConta)")
	List<Double> findValores(Long idConta);
}
