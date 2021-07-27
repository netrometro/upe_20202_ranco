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
		return pacienteService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> getMedicacao(@PathVariable Long id){
		return pacienteService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Paciente> createMedicacao(@RequestBody Paciente paciente){
		return pacienteService.create(paciente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente>updateMedicacao(@PathVariable long id, @RequestBody Paciente paciente){
		return pacienteService.update(id, paciente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Paciente> deleteMedicacao(@PathVariable long id){
		return pacienteService.delete(id);
	}
}
