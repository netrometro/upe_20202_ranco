package application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.dao.IPacienteDAO;
import application.models.Paciente;
import application.models.enums.TipoDeUsuario;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PacienteCRUDService {
	
	@Autowired
	private IPacienteDAO pacientes;
	@Autowired
	private PasswordEncriptionAndDecription encription;
	
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
		String encodedPass = encription.encode(pacienteParam.getSenha());
		pacienteParam.setSenha(encodedPass);
		pacienteParam.setDataInclusao(LocalDateTime.now());
		Paciente paciente = pacientes.save(pacienteParam);
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
		paciente.get().setDataModificacao(LocalDateTime.now());
		return pacientes.save(paciente.get());
		
	}
	
}
