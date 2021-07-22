package application.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Psicologo extends Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_psicologo;
	private String crp;

	public Psicologo(String crp) {
		super();
		this.crp = crp;
	}
	
}
