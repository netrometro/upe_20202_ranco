package application.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.PacienteDTO;
import application.dto.dadosGraficoDTO;
import application.dto.dashboardDTO;
import application.dto.listaEventosDTO;
import application.dto.listaMedicacoesDTO;
import application.models.Evento;
import application.models.Medicacao;
import application.models.Paciente;
import application.services.PacienteCRUDService;
import lombok.extern.slf4j.Slf4j;


@RequestMapping("")
@RestController
@Slf4j
public class paginasController {

	@Autowired
	private PacienteCRUDService pacienteService;
	@GetMapping("/dashboard/{id}")
	public ResponseEntity<dashboardDTO> getPaciente(@PathVariable Long id){
		PacienteDTO paciente = pacienteService.findById(id);
		
		dashboardDTO board = new dashboardDTO(paciente);
		if(paciente == null) {
			
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(board);
			
		}
	}
	
	@GetMapping("/eventos/{id}")
	public ResponseEntity<listaEventosDTO> getEventos(@PathVariable Long id){
		PacienteDTO paciente = pacienteService.findById(id);
		List<Evento> eventos= paciente.getEventos();
		Collections.reverse(eventos);
		listaEventosDTO eventosDTO = new listaEventosDTO(eventos);
		return ResponseEntity.ok(eventosDTO);
	}
	
	@GetMapping("/medicacoes/{id}")
	public ResponseEntity<listaMedicacoesDTO> getMedicacoes(@PathVariable Long id){
		PacienteDTO paciente = pacienteService.findById(id);
		List<Medicacao> medicacoes= paciente.getMedicacoes();
		Collections.reverse(medicacoes);
		listaMedicacoesDTO medicacoesDTO = new listaMedicacoesDTO(medicacoes);
		return ResponseEntity.ok(medicacoesDTO);
	}
	
	@GetMapping("/dados/{id}")
	public ResponseEntity<dadosGraficoDTO> getDados(@PathVariable Long id){
		PacienteDTO paciente = pacienteService.findById(id);
		List<Evento> eventos= paciente.getEventos();
		dadosGraficoDTO dadosDTO = new dadosGraficoDTO(eventos);
		return ResponseEntity.ok(dadosDTO);
	}
	
	
}
