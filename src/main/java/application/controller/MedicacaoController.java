package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Medicacao;
import application.repositories.MedicacaoRepository;
import application.services.MedicacaoService;

@RequestMapping("/api/medicacoes")
@RestController
public class MedicacaoController {

	@Autowired
	MedicacaoService medicacaoService;
	
	@GetMapping
	public ResponseEntity<List<Medicacao>> getMedicacoes(){
		return medicacaoService.findAll();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicacao> getMedicacao(@PathVariable Long id){
		return medicacaoService.findById(id);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Medicacao> createMedicacao(@PathVariable Long id, @RequestBody Medicacao medicao){
		return medicacaoService.create(id, medicao);
	}
}
