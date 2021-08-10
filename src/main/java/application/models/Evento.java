package application.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import application.models.abstracts.DbEntity;
import lombok.Data;

@Data
@Entity
public class Evento extends DbEntity {
	
	private Date data;
	private String local;
	private String pessoaEnvolvida;
	private String descricao;
	private int categoria;
	private String pontoMelhoria;
	private String feedback;
	private boolean status;
	private String sentimentos;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonBackReference
	private Paciente usuario;

	public Evento() {
	}

	public Evento(Date data, String local, String pessoaEnvolvida,String descricao, int categoria, 
			String pontoMelhoria, String feedback, boolean status, String sentimentos, Paciente usuario) {
		super();
		this.data = data;
		this.local = local;
		this.pessoaEnvolvida = pessoaEnvolvida;
		this.descricao = descricao;
		this.categoria = categoria;
		this.pontoMelhoria = pontoMelhoria;
		this.feedback = feedback;
		this.status = status;
		this.sentimentos = sentimentos;
		this.usuario = usuario;
	}

}