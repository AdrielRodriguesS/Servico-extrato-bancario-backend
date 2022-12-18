package br.com.banco.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transferencia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_transferencia")
	private LocalDate dataTransferência;
	private BigDecimal valor;
	@Column(name = "tipo")
	private String tipoTransfência;
	private String nomeOperadorTransacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	public Transferencia() {
	}

	public Transferencia(Long id, LocalDate dataTransferência, BigDecimal valor, String tipoTransfência,
			String nomeOperadorTransacao) {
		this.id = id;
		this.dataTransferência = dataTransferência;
		this.valor = valor;
		this.tipoTransfência = tipoTransfência;
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataTransferência() {
		return dataTransferência;
	}

	public void setDataTransferência(LocalDate dataTransferência) {
		this.dataTransferência = dataTransferência;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipoTransfência() {
		return tipoTransfência;
	}

	public void setTipoTransfência(String tipoTransfência) {
		this.tipoTransfência = tipoTransfência;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}
}
