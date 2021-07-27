/**
 * 
 */
package application.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Paciente;
import application.services.PacienteService;

/**
 * @author Dahis
 *
 */

@RequestMapping("/api/Pacientes")
@RestController
public class PacienteController extends HttpServlet {

	private PacienteService pacienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Paciente>> getAll(){
		return pacienteService.findAll();
	}
}
