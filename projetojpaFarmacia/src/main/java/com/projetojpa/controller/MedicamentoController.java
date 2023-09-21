package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Medicamento;
import com.projetojpa.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {



	private final MedicamentoService medicamentoService;

	@Autowired
	public MedicamentoController(MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> buscaMedicamentoControlId(@PathVariable Long id){
		Medicamento medicamento = medicamentoService.buscaMedicamentoId(id);
		if(medicamento != null) {
			return ResponseEntity.ok(medicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping("/")
	public ResponseEntity<List<Medicamento>> buscaTodosMedicamentosControl(){
		List<Medicamento> medicamento =  medicamentoService.buscaTodosMedicamento();
		return ResponseEntity.ok(medicamento);
	}

	@PostMapping("/")
	public ResponseEntity<Medicamento> salvaMedicamentoControl(@RequestBody Medicamento medicamento){
		Medicamento salvaMedicamento = medicamentoService.salvaMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaMedicamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Medicamento> alterarMedicamentosControl(@PathVariable Long id, @RequestBody Medicamento medicamento){
		Medicamento alterarMedicamentos = medicamentoService.alterarMedicamento( id, medicamento);
		if(alterarMedicamentos != null) {
			return ResponseEntity.ok(medicamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarMedicamentoControl(@PathVariable Long id){
		boolean apagar = medicamentoService.apagaMedicamento(id);
		if(apagar) {
			return ResponseEntity.ok().body("O medicamento foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}


