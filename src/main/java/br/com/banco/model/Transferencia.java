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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transferencia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_transferencia")
	private LocalDate dataTransferencia;
	private BigDecimal valor;
	@Column(name = "tipo")
	private String tipoTransferencia;
	private String nomeOperadorTransacao;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conta_id")
	private Conta conta;
	
	public Transferencia() {
	}

	public Transferencia(Long id, LocalDate dataTransferencia, BigDecimal valor, String tipoTransferencia,
			String nomeOperadorTransacao, Conta conta) {
		this.id = id;
		this.dataTransferencia = dataTransferencia;
		this.valor = valor;
		this.tipoTransferencia = tipoTransferencia;
		this.nomeOperadorTransacao = nomeOperadorTransacao;
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipoTransferencia() {
		return tipoTransferencia;
	}

	public void setTipoTransferencia(String tipoTransferencia) {
		this.tipoTransferencia = tipoTransferencia;
	}

	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}

	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public void setContaId(Long id) {
		this.conta.setId(id);
	}
	
	
}
