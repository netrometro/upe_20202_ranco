package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Medicacao;
import application.repositories.MedicacaoRepository;

@RestController
public class MedicacaoController {

	@Autowired
	MedicacaoRepository repository;
	
	@GetMapping("/api/medicacoes")
	public List<Medicacao> getMedicacoes(){
		
		return (List<Medicacao>) repository.findAll();				
	}
}
