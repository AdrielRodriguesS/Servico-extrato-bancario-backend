package br.com.banco.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.banco.model.Transferencia;
import br.com.banco.util.PopularBancoTest;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferenciaRepositoryTest {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private  ContaRepository contaRepository;

	private PopularBancoTest popularBanco = new PopularBancoTest();
	
	@BeforeAll
	public void popularBanco() {
		popularBanco.popularBanco(contaRepository, transferenciaRepository);
	}
		
	@Test
	public void deveriaCarregarDuasTransferenciasPelaContaEntreDuasDatas(){
		
		LocalDate data = LocalDate.of(2018, 01, 01);
		LocalDate agora = LocalDate.now();
		
		List<Transferencia> transferencias = new ArrayList<>();
		
		transferencias = transferenciaRepository.findTransferencias(data, agora, 1l);
		
		Assertions.assertEquals(transferencias.size(), 2);
		
	}
	
	@Test
	public void deveriaCarregarUmaTransferenciasPelaContaEntreDuasDatasComNomeOperador(){
		
		LocalDate data = LocalDate.of(2018, 01, 01);
		LocalDate agora = LocalDate.now();
		
		List<Transferencia> transferencias = new ArrayList<>();
		
		transferencias = transferenciaRepository.findTransferenciasComOperador(data, agora, "PessoaQuatro", 2l);
		
		Assertions.assertEquals(transferencias.size(), 1);
		
	}
	
	@Test
	public void deveriaCarregarDuasTransferenciasPelaConta(){

		List<Transferencia> transferencias = new ArrayList<>();
		
		transferencias = transferenciaRepository.findTodasTransferencias(1l);
		
		Assertions.assertEquals(transferencias.size(), 2);
	}
	
	@Test
	public void deveriaCarregarDoisValoresDoublePelaConta(){

		List<Double> valores = new ArrayList<>();
		
		valores = transferenciaRepository.findValores(2l);
		
		Double valorUm = valores.get(0);
		Double valorDois = valores.get(1);
		
		Assertions.assertEquals(valorUm, 1500);
		Assertions.assertEquals(valorDois, 50);
	}

}
