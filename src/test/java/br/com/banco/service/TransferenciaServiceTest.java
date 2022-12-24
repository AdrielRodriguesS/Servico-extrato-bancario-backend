package br.com.banco.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.util.PopularBancoTest;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferenciaServiceTest {
	
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;

	private TransferenciaService service = new TransferenciaService();
	
	@Autowired
	private  ContaRepository contaRepository;

	private PopularBancoTest popularBanco = new PopularBancoTest();
	
	@BeforeAll
	public void popularBanco() {
		popularBanco.popularBanco(contaRepository, transferenciaRepository);
	}
	
	@Test
	public void deveriaRetornarCincoMilEQuinhentos() {		
		
		Double valor = service.buscarValores("1", transferenciaRepository);
		
		Assertions.assertEquals(valor, 5500);		
	}

}
