package application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dao.IEventoDao;
import application.dao.ISentimentoDao;
import application.models.Evento;
import application.models.Sentimento;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SentimentoCRUDService {
	
	 @Autowired
	 private ISentimentoDao sentimentos;

	 @Autowired
	 private IEventoDao eventos;

	 public List<Sentimento> findAll() {
	   return sentimentos.findAll();
	  }

	public Sentimento findById(Long id_sentimento) {
		    Optional<Sentimento> sentimento = sentimentos.findById(id_sentimento);
		    if (!sentimento.isPresent()) {
		      return null;
		    } else {
		      return sentimento.get();
		    }
		  }
	
	public Sentimento create(long id_evento, Sentimento sentimento) {
	    Optional<Evento> evento = eventos.findById(id_evento);
	    if (!evento.isPresent()) {
	      return null;
	    }
	    
	    sentimento.setDataInclusao(LocalDateTime.now());
	    sentimento.setEvento(evento.get());
	    return sentimentos.save(sentimento);
	  }
	
	public Sentimento update(long id, Sentimento sentimentoParam) {
	    Optional<Sentimento> sentimento = sentimentos.findById(id);
	    if (!sentimento.isPresent()) {
	      return create(id, sentimentoParam);
	    }
	    
	    if (!(sentimentoParam.getData() == null)) {
	      sentimento.get().setData(sentimentoParam.getData());
	    }
	    if (!(sentimentoParam.getDescarrego() == null)) {
	      sentimento.get().setDescarrego(sentimentoParam.getDescarrego());
	    }
	    if (!(sentimentoParam.getTipoSentimento() == null)) {
	      sentimento.get().setTipoSentimento(sentimentoParam.getTipoSentimento());
	    }
	    if (!(sentimentoParam.getGrauSentimento() == null)) {
		      sentimento.get().setGrauSentimento(sentimentoParam.getGrauSentimento());
		}
	    if (!(sentimentoParam.getEvento() == null)) {
		      sentimento.get().setEvento(sentimentoParam.getEvento());
		}
	    
	    sentimento.get().setDataModificacao(LocalDateTime.now());
	    return sentimentos.save(sentimento.get());

	  }

	  public Sentimento delete(long id) {
	    Optional<Sentimento> sentimento = sentimentos.findById(id);
	    if (!sentimento.isPresent()) {
	      return null;
	    }
	    sentimentos.delete(sentimento.get());
	    return sentimento.get();
	  }


}
