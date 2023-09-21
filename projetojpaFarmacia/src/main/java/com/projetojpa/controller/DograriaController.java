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

import com.projetojpa.entities.Dograria;
import com.projetojpa.service.DograriaService;

@RestController
@RequestMapping("/dograria")
public class DograriaController {



	private final DograriaService dograriaService ;

	@Autowired
	public DograriaController(DograriaService dograriaService) {
		this.dograriaService = dograriaService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Dograria> buscaDograriaControlId(@PathVariable Long id){
		Dograria dograria = dograriaService.buscaDograriaId(id);
		if(dograria != null) {
			return ResponseEntity.ok(dograria);
		}
		else {
			return ResponseEntity.notFound().build();
		}

	}
	@GetMapping("/")
	public ResponseEntity<List<Dograria>> buscaTodosDograriaControl(){
		List<Dograria> dograria =  dograriaService.buscaTodosDrograria();
		return ResponseEntity.ok(dograria);
	}

	@PostMapping("/")
	public ResponseEntity<Dograria> salvaDograriaControl(@RequestBody Dograria dograria){
		Dograria salvaDograria = dograriaService.salvaDograria(dograria);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDograria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Dograria> alterarDograriaControl(@PathVariable Long id, @RequestBody Dograria dograria){
		Dograria alterarDograria = dograriaService.alterarDograria( id, dograria);
		if(alterarDograria != null) {
			return ResponseEntity.ok(dograria);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagarDograriaControl(@PathVariable Long id){
		boolean apagar = dograriaService.apagaDograria(id);
		if(apagar) {
			return ResponseEntity.ok().body("A Drograria foi excluído com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
