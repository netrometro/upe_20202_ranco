package application.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import application.models.abstracts.DbEntity;
import lombok.Data;

@Data
@Entity
public class Medicacao extends DbEntity{
		
	private String nome;
	private String posologia;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonBackReference
	private Paciente usuario;

	protected Medicacao() {}
	
	public Medicacao(String nome, String posologia) {
		super();
		this.nome = nome;
		this.posologia = posologia;
	}

	public Medicacao(String nome, String posologia, Paciente usuario) {
		super();
		this.nome = nome;
		this.posologia = posologia;
		this.usuario = usuario;
	}

}
