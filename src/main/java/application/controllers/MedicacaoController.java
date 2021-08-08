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

import application.dao.IMedicacaoDao;
import application.models.Medicacao;
import application.services.MedicacaoService;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RequestMapping("/api/medicacoes")
@RestController
public class MedicacaoController {

	@Autowired
	MedicacaoService medicacaoService;
	
	@GetMapping
	public ResponseEntity<List<Medicacao>> getMedicacoes(){
		return ResponseEntity.ok(medicacaoService.findAll());
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicacao> getMedicacao(@PathVariable Long id){
		Medicacao medicacao = medicacaoService.findById(id);
		if(medicacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicacao);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Medicacao> createMedicacao(@PathVariable Long id, @RequestBody Medicacao medicao){
		try {
			return ResponseEntity.ok(medicacaoService.create(id, medicao));			
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicacao> updateMedicacao(@PathVariable long id, @RequestBody Medicacao medicacao){
		Medicacao medicamento = medicacaoService.update(id, medicacao);
		if(medicamento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicamento);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medicacao> deleteMedicacao(@PathVariable long id){
		Medicacao medicamento = medicacaoService.delete(id);
		if(medicamento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicamento);
	}
}
