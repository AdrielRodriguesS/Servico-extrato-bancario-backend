package br.com.banco.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long id;
	@Column(name = "nome_responsavel")
	private String nomeResponsavel;
	
	@OneToMany(mappedBy = "conta")
	private List<Transferencia> transferencias = new ArrayList<>();

	public Conta() {
	}

	public Conta(Long id, String nomeResponsavel) {
		this.id = id;
		this.nomeResponsavel = nomeResponsavel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}	

}
