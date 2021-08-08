package application.models.abstracts;

import javax.persistence.MappedSuperclass;

import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Usuario extends DbEntity{
	
	private String nome;
	private String email;
	private String senha;
	private TipoDeUsuario tipoUsuario;

	protected Usuario() {}
	
	public Usuario(String nome, String email, String senha, TipoDeUsuario tipoUsuario) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
	

}
