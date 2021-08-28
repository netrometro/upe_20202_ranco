package application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.PsicologoDTO;
import application.models.Psicologo;
import application.services.PsicologoCRUDService;

@RequestMapping("/api/psicologos")
@RestController

public class PsicologoCRUDController {
	@Autowired
	PsicologoCRUDService psicologoService;

	@GetMapping
	public ResponseEntity<List<PsicologoDTO>> getMedicacoes() {
		return ResponseEntity.ok(psicologoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PsicologoDTO> getPsicologo(@PathVariable Long id) {
		PsicologoDTO byId = psicologoService.findById(id);
		if(byId == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(byId);
	}

	@PostMapping
	public ResponseEntity<PsicologoDTO> createPsicologo(@Valid @RequestBody Psicologo psicologo) {
		if(psicologo.getNome() == null) {
			return ResponseEntity.badRequest().build();
		}
		if(psicologo.getSenha() == null) {
			return ResponseEntity.badRequest().build();
		}
		if(psicologo.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		if(psicologo.getTipoUsuario() == null) {
			return ResponseEntity.badRequest().build();
		}
		if(psicologo.getCrp() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		PsicologoDTO create = psicologoService.create(psicologo);
		if(create == null) {			
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(create);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PsicologoDTO> updatePsicologo(@PathVariable long id, @RequestBody Psicologo psicologo) {
		PsicologoDTO psicologo2 = psicologoService.update(id, psicologo);
		if(psicologo2 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(psicologo2);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PsicologoDTO> deletePsicologo(@PathVariable long id) {
		PsicologoDTO psicologo = psicologoService.delete(id);
		if(psicologo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(psicologo);
	}
}
