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

import application.models.Psicologo;
import application.services.PsicologoCRUDService;

@RequestMapping("/api/psicologos")
@RestController

public class PsicologoCRUDController {
	@Autowired
	PsicologoCRUDService psicologoService;

	@GetMapping
	public ResponseEntity<List<Psicologo>> getMedicacoes() {
		return ResponseEntity.ok(psicologoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Psicologo> getPsicologo(@PathVariable Long id) {
		Psicologo byId = psicologoService.findById(id);
		if(byId == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(byId);
	}

	@PostMapping
	public ResponseEntity<Psicologo> createPsicologo(@Valid @RequestBody Psicologo psicologo) {
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
		
		return ResponseEntity.ok(psicologoService.create(psicologo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Psicologo> updatePsicologo(@PathVariable long id, @RequestBody Psicologo psicologo) {
		Psicologo psicologo2 = psicologoService.update(id, psicologo);
		if(psicologo2 == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(psicologo2);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Psicologo> deletePsicologo(@PathVariable long id) {
		Psicologo psicologo = psicologoService.delete(id);
		if(psicologo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(psicologo);
	}
}
