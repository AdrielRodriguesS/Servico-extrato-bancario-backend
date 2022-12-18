package br.com.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	ContaRepository contaRepository;
	
	public Conta BuscarContaPorId(Long id) {
		return contaRepository.findById(id).get();
	}

}
