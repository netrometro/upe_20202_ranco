package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.dao.PacienteRepository;
import application.models.Paciente;
import application.models.enums.TipoDeUsuario;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacientes;
	
	public List<Paciente> findAll(){
		return pacientes.findAll();
	}
	
	public Paciente findById(Long id_paciente){
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		if(!paciente.isPresent()) {
			return null;
		}
		else {
			return paciente.get();
		}
	}
	
	public Paciente create(Paciente pacienteParam){
		Paciente paciente = pacientes.save(new Paciente(pacienteParam.getNome(), pacienteParam.getEmail(), pacienteParam.getSenha(), pacienteParam.getTipoUsuario()));
		return paciente;
	}
	
	public Paciente delete(Long id_paciente){
		
		if(pacientes.existsById(id_paciente)) {
			Optional<Paciente> paciente = pacientes.findById(id_paciente);
			pacientes.delete(paciente.get());
			return paciente.get();
		}
		return null;
	}
	
	public Paciente update(Long id_paciente, Paciente pacienteParam){
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		
		if(!paciente.isPresent()) {
			return null;
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
		return pacientes.save(paciente.get());
		
	}
	
}
