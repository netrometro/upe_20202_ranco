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

import application.dao.EventoRepository;
import application.models.Evento;
import application.services.EventoService;
import io.micrometer.core.ipc.http.HttpSender.Response;


@RequestMapping("/api/eventos")
@RestController
public class EventoController {
	
	@Autowired
	EventoService eventoService;
	
	@GetMapping
	public ResponseEntity<List<Evento>> getEventos(){
		return eventoService.findAll();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Evento> getEvento(@PathVariable Long id){
		return eventoService.findById(id);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Evento> createEvento(@PathVariable Long id, @RequestBody Evento evento){
		return eventoService.create(id, evento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Evento> updateEvento(@PathVariable long id, @RequestBody Evento evento){
		return eventoService.update(id, evento);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Evento> deleteEvento(@PathVariable long id){
		return eventoService.delete(id);
	}
	


}
