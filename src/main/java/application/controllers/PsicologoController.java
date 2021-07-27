package application.controllers;

import java.util.List;

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
import application.services.PsicologoService;

@RequestMapping("/api/psicologos")
@RestController

public class PsicologoController {
	@Autowired
	PsicologoService psicologoService;

	@GetMapping
	public ResponseEntity<List<Psicologo>> getMedicacoes() {
		return psicologoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Psicologo> getPsicologo(@PathVariable Long id) {
		return psicologoService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Psicologo> createPsicologo(@RequestBody Psicologo psicologo) {
		return psicologoService.create(psicologo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Psicologo> updatePsicologo(@PathVariable long id, @RequestBody Psicologo psicologo) {
		return psicologoService.update(id, psicologo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Psicologo> deletePsicologo(@PathVariable long id) {
		return psicologoService.delete(id);
	}
}
