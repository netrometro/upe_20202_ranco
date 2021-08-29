package application.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dao.IEventoDao;
import application.dto.eventoDTO;
import application.models.Evento;
import application.services.EventoCRUDService;
import io.micrometer.core.ipc.http.HttpSender.Response;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("/api/eventos")
@RestController
@Slf4j
public class EventoCRUDController {
	
	@Autowired
	EventoCRUDService eventoService;
	
	@GetMapping
	public ResponseEntity<List<Evento>> getEventos(){
		return ResponseEntity.ok(eventoService.findAll());
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Evento> getEvento(@PathVariable Long id){
		Evento evento = eventoService.findById(id);
		if (evento == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(evento);
	}
	
	@PostMapping("/{id}")

	public ResponseEntity<eventoDTO> createEvento(@PathVariable Long id, @Valid @RequestBody Evento evento){
		try {
			eventoDTO eventodto = new eventoDTO(eventoService.create(id, evento));
			return ResponseEntity.ok(eventodto);		
		}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Evento> updateEvento(@PathVariable long id, @RequestBody Evento evento){
		Evento eventos = eventoService.update(id, evento);
		if(eventos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(eventos);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Evento> deleteEvento(@PathVariable long id){
		Evento eventos = eventoService.delete(id);
		if(eventos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(eventos);
	}
	


}
