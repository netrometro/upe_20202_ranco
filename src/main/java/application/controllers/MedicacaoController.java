package application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Medicacao;
import application.repositories.MedicacaoRepository;
import application.services.MedicacaoService;
import io.micrometer.core.ipc.http.HttpSender.Response;

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
		return ResponseEntity.ok(medicacaoService.create(id, medicao));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicacao> updateMedicacao(@PathVariable long id, @RequestBody Medicacao medicacao){
		return medicacaoService.update(id, medicacao);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medicacao> deleteMedicacao(@PathVariable long id){
		return medicacaoService.delete(id);
	}
}
