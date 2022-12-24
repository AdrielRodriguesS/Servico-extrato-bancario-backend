package br.com.banco.util;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.test.context.ActiveProfiles;

import br.com.banco.model.Conta;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.ContaRepository;
import br.com.banco.repository.TransferenciaRepository;

@ActiveProfiles("test")	
public class PopularBancoTest {	
	
	public void popularBanco(ContaRepository contaRepository, TransferenciaRepository transferenciaRepository) {
		
		Conta contaUm = criarConta("PessoaUm");
		Conta contaDois = criarConta("PessoaDois");
		
		LocalDate dataUm = LocalDate.of(2019, 01, 01);
		LocalDate dataDois = LocalDate.of(2019, 05, 05);
		LocalDate dataTres = LocalDate.of(2020, 01, 01);
		LocalDate dataQuatro = LocalDate.of(2021, 01, 01);
		
		Transferencia tranfUm = criarTransferencia(dataUm, "DEPOSITO", new BigDecimal(500), "", contaUm);
		Transferencia tranfDois = criarTransferencia(dataDois, "SAQUE", new BigDecimal(1500), "", contaDois);
		Transferencia tranfTres = criarTransferencia(dataTres, "TRANSFERENCIA", new BigDecimal(5000), "PessoaTres", contaUm);
		Transferencia tranfQuatro = criarTransferencia(dataQuatro, "DEPOSITO", new BigDecimal(50), "PessoaQuatro", contaDois);
		
		cadastrarConta(contaUm, contaRepository);
		cadastrarConta(contaDois, contaRepository);
		
		cadastrarTransferencia(tranfUm, transferenciaRepository);
		cadastrarTransferencia(tranfDois, transferenciaRepository);
		cadastrarTransferencia(tranfTres, transferenciaRepository);
		cadastrarTransferencia(tranfQuatro, transferenciaRepository);
	}
	
	public void cadastrarConta(Conta conta, ContaRepository contaRepository) {
		contaRepository.save(conta);		
	}
	
	public void cadastrarTransferencia(Transferencia transferencia, TransferenciaRepository transferenciaRepository) {
		transferenciaRepository.save(transferencia);
	}
		
	public Conta criarConta(String nomeResponsavel) {		
		Conta conta = new Conta();
		conta.setNomeResponsavel(nomeResponsavel);
		return conta;		
	}
	
	public Transferencia criarTransferencia(LocalDate data, String tipo, BigDecimal valor, String operador, Conta conta) {
		
		Transferencia transferencia = new Transferencia();		
		
		transferencia.setDataTransferencia(data);
		transferencia.setTipoTransferencia(tipo);
		transferencia.setValor(valor);
		transferencia.setNomeOperadorTransacao(operador);
		transferencia.setConta(conta);
		transferencia.setContaId(conta.getId());
		
		return transferencia;
	
	}		

}
