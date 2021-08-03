/**
 * 
 */
package application.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;

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

import application.models.Paciente;
import application.services.PacienteService;

/**
 * @author Dahis
 *
 */

@RequestMapping("/api/pacientes")
@RestController
public class PacienteController extends HttpServlet {

	@Autowired
	private PacienteService pacienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Paciente>> getAll(){
		return ResponseEntity.ok(pacienteService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> getPaciente(@PathVariable Long id){
		Paciente paciente = pacienteService.findById(id);
		if(paciente == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(paciente);
			
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente){
		try {
			return ResponseEntity.ok(pacienteService.create(paciente));
		}catch(Exception e)
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable long id, @RequestBody Paciente paciente){
		if(paciente == null) {
			return ResponseEntity.notFound().build();
		}else 
		{
			return ResponseEntity.ok(pacienteService.update(id, paciente));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> deletePaciente(@PathVariable long id){
		try {
			return ResponseEntity.ok(pacienteService.delete(id));
		}catch(Exception e)
		{
			return ResponseEntity.notFound().build();
		}
	}
}
