package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Conta;
import br.com.banco.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarPorId(@PathVariable Long id){
		Conta conta = this.contaService.BuscarContaPorId(id);
		return ResponseEntity.ok(conta);
	}

}
