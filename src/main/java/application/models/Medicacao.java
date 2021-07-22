package application.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Medicacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_medicacao;		
	private String nome;
	private String posologia;
	
	@ManyToOne	
	private Usuario usuario;

	public Medicacao(String nome, String posologia) {
		super();
		this.nome = nome;
		this.posologia = posologia;
	}

}
