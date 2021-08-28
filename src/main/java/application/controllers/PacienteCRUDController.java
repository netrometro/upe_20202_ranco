/**
 * 
 */
package application.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.dto.PacienteDTO;
import application.models.Paciente;
import application.services.PacienteCRUDService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Dahis
 *
 */

@RequestMapping("/api/pacientes")
@RestController
@Slf4j
public class PacienteCRUDController extends HttpServlet {

	@Autowired
	private PacienteCRUDService pacienteService;
	
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> getAll(){
		return ResponseEntity.ok(pacienteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> getPaciente(@PathVariable Long id){
		PacienteDTO paciente = pacienteService.findById(id);
		if(paciente == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(paciente);
			
		}
		
	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> createPaciente(@Valid @RequestBody Paciente paciente){
		try {
			return ResponseEntity.ok(pacienteService.create(paciente));
		}catch(Exception e)
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable long id, @RequestBody Paciente paciente){
		if(paciente == null) {
			return ResponseEntity.notFound().build();
		}else 
		{
			return ResponseEntity.ok(pacienteService.update(id, paciente));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PacienteDTO> deletePaciente(@PathVariable long id){
		try {
			return ResponseEntity.ok(pacienteService.delete(id));
		}catch(Exception e)
		{
			return ResponseEntity.notFound().build();
		}
	}
}
