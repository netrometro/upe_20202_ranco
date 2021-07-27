package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Paciente;
import application.models.enums.TipoDeUsuario;
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
	
	public ResponseEntity<Paciente> create(Paciente pacienteParam){
		Paciente paciente = pacientes.save(new Paciente(pacienteParam.getNome(), pacienteParam.getEmail(), pacienteParam.getSenha(), pacienteParam.getTipoUsuario()));
		return ResponseEntity.ok(paciente);
	}
	
	public ResponseEntity<Paciente> delete(Long id_paciente){
		
		if(pacientes.existsById(id_paciente)) {
			Optional<Paciente> paciente = pacientes.findById(id_paciente);
			pacientes.delete(paciente.get());
			return ResponseEntity.ok(paciente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<Paciente> update(Long id_paciente, Paciente pacienteParam){
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		
		if(paciente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		if(!(pacienteParam.getNome() == null)) {
			paciente.get().setNome(pacienteParam.getNome());
		}
		if(!(pacienteParam.getEmail() == null)) {
			paciente.get().setEmail(pacienteParam.getEmail());
		}
		if(!(pacienteParam.getSenha() == null)) {
			paciente.get().setSenha(pacienteParam.getSenha());	
		}
		if(!(pacienteParam.getTipoUsuario() == null)) {
			paciente.get().setTipoUsuario(pacienteParam.getTipoUsuario());
		}
		return ResponseEntity.ok(paciente.get());
		
	}
	
}
