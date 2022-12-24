package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;	
	
	public Transferencia buscarTransferenciaPorId(Long id) {
		
		return transferenciaRepository.findById(id).get();

	}

	public List<Transferencia> buscarTransferencias(String minDate, String maxDate, String nomeOperador, String id) {

		Long idConta = Long.parseLong(id);
		
		
		if(minDate.isEmpty() || maxDate.isEmpty()) {

			return transferenciaRepository.findTodasTransferencias(idConta);
			
		} else if (!minDate.isEmpty() & !maxDate.isEmpty() & nomeOperador.isEmpty()){
			
			LocalDate min = LocalDate.parse(minDate);
			LocalDate max = LocalDate.parse(maxDate);
			return transferenciaRepository.findTransferencias(min, max, idConta);
		
		} else {
		
			LocalDate min = LocalDate.parse(minDate);
			LocalDate max = LocalDate.parse(maxDate);
			return transferenciaRepository.findTransferenciasComOperador(min, max, nomeOperador, idConta);
		}
		
	}
	
	public Double buscarValores(String id){
		
		Long idConta = Long.parseLong(id);
		
		List<Double> valores = transferenciaRepository.findValores(idConta);
		Double totalConta = 0.0;
		for(Double v : valores) {
			totalConta += v;
		}
		return totalConta;
	}
	
	public Double buscarValores(String id, TransferenciaRepository transferenciaRepository){
		
		Long idConta = Long.parseLong(id);
		
		List<Double> valores = transferenciaRepository.findValores(idConta);
		Double totalConta = 0.0;
		for(Double v : valores) {
			totalConta += v;
		}
		return totalConta;
	}
	
	
	
}
