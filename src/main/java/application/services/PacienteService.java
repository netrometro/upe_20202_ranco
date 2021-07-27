package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Paciente;
import application.repositories.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacientes;
	
	public ResponseEntity<List<Paciente>> findAll(){
		return ResponseEntity.ok(pacientes.findAll());
	}
	
	public ResponseEntity<Paciente> findById(Long id_paciente){
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		if(paciente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(paciente.get());
		}
	}
	
}
