package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Dograria;
import com.projetojpa.repository.DograriaRepository;

@Service
	public class DograriaService {
	
		private final DograriaRepository dograriaRepository;

		@Autowired
		public DograriaService(DograriaRepository dograriaRepository) {
			this.dograriaRepository = dograriaRepository;
		}
		public List<Dograria> buscaTodosDrograria(){
			return dograriaRepository.findAll();
		}
		
		public  Dograria  buscaDograriaId(Long id) {
			Optional <Dograria> dograria = dograriaRepository.findById(id);
			return dograria.orElse(null);
		}
		
		public Dograria salvaDograria(Dograria dograria) {
			return dograriaRepository.save(dograria);
		}
		
		public Dograria alterarDograria(Long id, Dograria alterarDograria) {
			Optional <Dograria> existeDograria = dograriaRepository.findById(id);
			if(existeDograria.isPresent()) {
				alterarDograria.setId(id);
				return dograriaRepository.save(alterarDograria);
			}
			return null;
		}
		public boolean apagaDograria(Long id) {
			Optional <Dograria> existeDograria = dograriaRepository.findById(id);
			if(existeDograria.isPresent()) {
				dograriaRepository.deleteById(id);
				return true;
			}
			return false;
		}

}
