package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Psicologo extends Usuario{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_psicologo;
	private String crp;

	public Psicologo(String crp) {
		this.crp = crp;
	}
	
}
