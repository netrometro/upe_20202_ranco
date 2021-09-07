package application.models;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import application.models.abstracts.DbEntity;
import application.models.enums.GrauSentimento;
import application.models.enums.TipoDeSentimento;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = {"evento"})
public class Sentimento extends DbEntity{
	
	private Date data;
	@NotBlank (message = "Descarrego é um campo obrigatório")
	private String descarrego;
	private TipoDeSentimento tipoSentimento;
	private GrauSentimento grauSentimento;
	
	@ManyToOne
	@JoinColumn(name = "id_evento")
	@JsonBackReference
	private Evento evento;
	
	public Sentimento() {
		
	}
	
	public Sentimento(Date data, String descarrego, TipoDeSentimento tipoSentimento, GrauSentimento grauSentimento, Evento evento ) {
		super();
		this.data = data;
		this.descarrego = descarrego;
		this.tipoSentimento = tipoSentimento;
		this.grauSentimento = grauSentimento;
		this.evento = evento;
	}

	

}
