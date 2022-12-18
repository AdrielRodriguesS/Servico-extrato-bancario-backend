package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("transferencias")
public class TransferenciaController {
	
	@Autowired
	TransferenciaService transferenciaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> BuscarPorId(@PathVariable Long id){
		Transferencia transferencia = this.transferenciaService.buscarTransferenciaPorId(id);
		return ResponseEntity.ok(transferencia);
	}

}
