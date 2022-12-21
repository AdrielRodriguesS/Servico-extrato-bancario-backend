package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@CrossOrigin
@RequestMapping("transferencias")
public class TransferenciaController {
	
	@Autowired
	TransferenciaService transferenciaService;
	
	@GetMapping("/{id}")
	public List<Transferencia> buscarTransferencias(@PathVariable String id,
			@RequestParam (value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate,
			@RequestParam(value="nomeOp", defaultValue = "") String nomeOperador){
		return transferenciaService.buscarTransferencias(minDate, maxDate, nomeOperador, id);
	}
	
	@GetMapping("/{id}/total-valores")
	public Double totalConta(@PathVariable String id) {
		return transferenciaService.buscarValores(id);
	}

}
