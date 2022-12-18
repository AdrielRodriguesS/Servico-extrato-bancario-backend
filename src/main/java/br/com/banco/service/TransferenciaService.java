package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
	
	@Autowired
	TransferenciaRepository transferenciaRespository;
	
	public Transferencia buscarTransferenciaPorId(Long id) {
		return transferenciaRespository.findById(id).get();
	}
	
}
