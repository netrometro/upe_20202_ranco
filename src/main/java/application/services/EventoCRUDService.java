package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

<<<<<<< HEAD:src/main/java/application/services/EventoService.java
import application.dao.EventoRepository;

=======
import application.controllers.EventoCRUDController;
import application.dao.IEventoDao;
import application.dao.PacienteRepository;
>>>>>>> 9b111eaa1778e9be3b48231bac2678711c71b1e7:src/main/java/application/services/EventoCRUDService.java
import application.models.Evento;
import application.models.Paciente;
import lombok.extern.slf4j.Slf4j;

import application.dao.IPacienteDAO;



@Service
@Slf4j
public class EventoCRUDService {
	
	@Autowired
	private IEventoDao eventos;
	
	@Autowired
	private IPacienteDAO pacientes;

	public List<Evento> findAll() {
		return eventos.findAll();
	}

	public Evento findById(Long id_evento) { 
		Optional<Evento> evento = eventos.findById(id_evento);
		if (!evento.isPresent()) {
			return null;
		}
		else {
			return evento.get();
		}
	}	
	
	public Evento create(long id_paciente, Evento evento){
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		if(!paciente.isPresent()) {
			return null;
		}
		evento.setUsuario(paciente.get());
		return eventos.save(evento);
	}
	
	
	public Evento update(long id, Evento eventoParam){
		Optional<Evento> evento = eventos.findById(id);
		if(!evento.isPresent()) {
			return null;
		}
		if(!(eventoParam.getData() ==null)) {
			evento.get().setData(eventoParam.getData());
		}
		if(!(eventoParam.getLocal() == null)) {
			evento.get().setLocal(eventoParam.getLocal()); 
		}
		if(!(eventoParam.getPessoaEnvolvida() ==null)) {
			evento.get().setPessoaEnvolvida(eventoParam.getPessoaEnvolvida());
		}
		if(!(eventoParam.getDescricao() == null)) {
			evento.get().setDescricao(eventoParam.getDescricao()); 
		}
		if(!(eventoParam.getCategoria() == 0)) {
			evento.get().setCategoria(eventoParam.getCategoria());
		}
		if(!(eventoParam.getPontoMelhoria() == null)) {
			evento.get().setPontoMelhoria(eventoParam.getPontoMelhoria()); 
		}
		if(!(eventoParam.getFeedback() == null)) {
			evento.get().setFeedback(eventoParam.getFeedback()); 
		}
		if(!(eventoParam.isStatus() == true)) {
			evento.get().setStatus(eventoParam.isStatus());
		}
		if(!(eventoParam.getSentimentos() == null)) {
			evento.get().setSentimentos(eventoParam.getSentimentos()); 
		}

		return eventos.save(evento.get());
		
	}
	
	public Evento delete(long id)
	{
		Optional<Evento> evento = eventos.findById(id);
		if(!evento.isPresent()) {
			return null;
		}
		eventos.delete(evento.get());
		return evento.get();
	}


}