package application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.dao.IEventoDao;
import application.dao.IPacienteDAO;
import application.models.Evento;
import application.models.Paciente;
import application.models.Sentimento;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventoCRUDService {

  @Autowired
  private IEventoDao eventos;

  @Autowired
  private IPacienteDAO pacientes;
  @Autowired
  private SentimentoCRUDService sentimentoService;

  public List<Evento> findAll() {
    return eventos.findAll();
  }

  public Evento findById(Long id_evento) {
    Optional<Evento> evento = eventos.findById(id_evento);
    if (!evento.isPresent()) {
      return null;
    } else {
      return evento.get();
    }
  }

  public Evento create(long id_paciente, Evento evento) {
    Optional<Paciente> paciente = pacientes.findById(id_paciente);
    if (!paciente.isPresent()) {
      return null;
    }
    evento.setDataInclusao(LocalDateTime.now());
    evento.setUsuario(paciente.get());
    System.out.println("create evento service=" + evento + "paciente = " + paciente);
    Evento e = eventos.save(evento);
    for(Sentimento s : evento.getSentimentos()) {    	
    	sentimentoService.create(e.getId(), s);
    }
    return e;
  }


  public Evento update(long id, Evento eventoParam) {
    Optional<Evento> evento = eventos.findById(id);
    if (!evento.isPresent()) {
      return null;
    }
    
    if (!(eventoParam.getTitulo() == null)) {
        evento.get().setTitulo(eventoParam.getTitulo());
      }
    if (!(eventoParam.getData() == null)) {
      evento.get().setData(eventoParam.getData());
    }
    if (!(eventoParam.getLocal() == null)) {
      evento.get().setLocal(eventoParam.getLocal());
    }
    if (!(eventoParam.getPessoaEnvolvida() == null)) {
      evento.get().setPessoaEnvolvida(eventoParam.getPessoaEnvolvida());
    }
    if (!(eventoParam.getDescricao() == null)) {
      evento.get().setDescricao(eventoParam.getDescricao());
    }
    if(!(eventoParam.getCategoria() == null)) {
		evento.get().setCategoria(eventoParam.getCategoria());
    }
    if (!(eventoParam.getPontoMelhoria() == null)) {
      evento.get().setPontoMelhoria(eventoParam.getPontoMelhoria());
    }
    if (!(eventoParam.getFeedback() == null)) {
      evento.get().setFeedback(eventoParam.getFeedback());
    }
    //if (!(eventoParam.isStatus() == null)) {
      evento.get().setStatus(eventoParam.isStatus());
    //}
    if (!(eventoParam.getMotivo() == null)) {
        evento.get().setMotivo(eventoParam.getMotivo());
    }
    if (!(eventoParam.getExpectativa() == null)) {
        evento.get().setExpectativa(eventoParam.getExpectativa());
    }
    
    evento.get().setDataModificacao(LocalDateTime.now());
    Evento e = eventos.save(evento.get());
    if(eventoParam.getSentimentos() != null) {
    	for(Sentimento s : eventoParam.getSentimentos()) {    	
    		sentimentoService.update(e.getId(), s);
    	}
    }
    return e;

  }

  public Evento delete(long id) {
    Optional<Evento> evento = eventos.findById(id);
    if (!evento.isPresent()) {
      return null;
    }
    eventos.delete(evento.get());
    return evento.get();
  }


}
