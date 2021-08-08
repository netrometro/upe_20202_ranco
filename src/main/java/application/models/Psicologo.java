package application.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import application.models.abstracts.Usuario;
import application.models.enums.TipoDeUsuario;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
public class Psicologo extends Usuario {

	private String crp;

	protected Psicologo() {
	}

	public Psicologo(String nome, String email, String senha, TipoDeUsuario tipoUsuario, String crp) {
		super(nome, email, senha, tipoUsuario);
		this.crp = crp;
		// TODO Auto-generated constructor stub
	}

	
	
	

}
