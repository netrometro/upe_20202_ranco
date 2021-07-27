package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Medicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_medicacao;		
	private String nome;
	private String posologia;
	
	@ManyToOne	
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