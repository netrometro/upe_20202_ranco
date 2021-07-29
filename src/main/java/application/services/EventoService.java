package application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import application.models.Evento;
import application.models.Paciente;
import application.repositories.EventoRepository;
import application.repositories.PacienteRepository;


@Service
public class EventoService {
	
	@Autowired
	private EventoRepository eventos;
	
	@Autowired
	private PacienteRepository pacientes;

	public ResponseEntity<List<Evento>> findAll() {
		return ResponseEntity.ok(eventos.findAll());
	}

	public ResponseEntity<Evento> findById(Long id_evento) { 
		Optional<Evento> evento = eventos.findById(id_evento);
		if (!evento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(evento.get());
		}
	}	
	
	public ResponseEntity<Evento> create(long id_paciente, Evento evento){
		Optional<Paciente> paciente = pacientes.findById(id_paciente);
		if(!paciente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		evento.setUsuario(paciente.get());
		return ResponseEntity.ok(eventos.save(evento));
	}
	
	
	public ResponseEntity<Evento> update(long id, Evento eventoParam){
		Optional<Evento> evento = eventos.findById(id);
		if(!evento.isPresent()) {
			return ResponseEntity.notFound().build();
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
		if(!(eventoParam.getTestemunhas() == null)) {
			evento.get().setTestemunhas(eventoParam.getTestemunhas()); 
		}
		if(!(eventoParam.getExpectativa() ==null)) {
			evento.get().setExpectativa(eventoParam.getExpectativa());
		}
		if(!(eventoParam.getDescricao() == null)) {
			evento.get().setDescricao(eventoParam.getDescricao()); 
		}
		if(!(eventoParam.getCategoria() == 0)) {
			evento.get().setCategoria(eventoParam.getCategoria());
		}
		if(!(eventoParam.getMotivo() == null)) {
			evento.get().setMotivo(eventoParam.getMotivo()); 
		}
		if(!(eventoParam.getProva() ==null)) {
			evento.get().setProva(eventoParam.getProva());
		}
		if(!(eventoParam.getPontoMelhoria() == null)) {
			evento.get().setPontoMelhoria(eventoParam.getPontoMelhoria()); 
		}
		if(!(eventoParam.getSolucao() == null)) {
			evento.get().setSolucao(eventoParam.getSolucao());
		}
		if(!(eventoParam.getFeedback() == null)) {
			evento.get().setFeedback(eventoParam.getFeedback()); 
		}
		if(!(eventoParam.isStatus() == true)) {
			evento.get().setStatus(eventoParam.isStatus());
		}
		if(!(eventoParam.getRecomendacao() == null)) {
			evento.get().setRecomendacao(eventoParam.getRecomendacao()); 
		}
		if(!(eventoParam.getSentimentos() == null)) {
			evento.get().setSentimentos(eventoParam.getSentimentos()); 
		}

		return ResponseEntity.ok(eventos.save(evento.get()));
		
	}
	
	public ResponseEntity<Evento> delete(long id)
	{
		Optional<Evento> evento = eventos.findById(id);
		if(!evento.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		eventos.delete(evento.get());
		return ResponseEntity.ok(evento.get());
	}


}
