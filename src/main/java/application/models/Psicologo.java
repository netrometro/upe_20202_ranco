package application.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Psicologo extends Usuario {

	private String crp;

	protected Psicologo() {
	}

	public Psicologo(String crp) {
		this.crp = crp;
	}

}
