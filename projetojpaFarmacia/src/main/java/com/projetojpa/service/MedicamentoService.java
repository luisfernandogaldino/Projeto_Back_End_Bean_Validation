package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Medicamento;
import com.projetojpa.repository.MedicamentoRepository;

@Service
	public class MedicamentoService {
	
		private final MedicamentoRepository medicamentoRepository;

		@Autowired
		public MedicamentoService(MedicamentoRepository medicamentoRepository) {
			this.medicamentoRepository = medicamentoRepository;
		}
		public <medicamentoRepository> List<Medicamento> buscaTodosMedicamento(){
			return medicamentoRepository.findAll();
		}
		
		public  Medicamento  buscaMedicamentoId(Long id) {
			Optional <Medicamento> Medicamento = medicamentoRepository.findById(id);
			return Medicamento.orElse(null);
		}
		
		public Medicamento salvaMedicamento(Medicamento medicamento) {
			return medicamentoRepository.save(medicamento);
		}
		
		public Medicamento alterarMedicamento(Long id, Medicamento alterarMedicamento) {
			Optional <Medicamento> existeMedicamento = medicamentoRepository.findById(id);
			if(existeMedicamento.isPresent()) {
				alterarMedicamento.setId(id);
				return medicamentoRepository.save(alterarMedicamento);
			}
			return null;
		}
		public boolean apagaMedicamento(Long id) {
			Optional <Medicamento> existeMedicamento = medicamentoRepository.findById(id);
			if(existeMedicamento.isPresent()) {
				medicamentoRepository.deleteById(id);
				return true;
			}
			return false;
		}

}
