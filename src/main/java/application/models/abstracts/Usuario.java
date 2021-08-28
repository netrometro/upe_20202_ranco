package application.models.abstracts;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class Usuario extends DbEntity{
	
	@NotBlank(message = "Name is mandatory")
	private String nome;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
		
	@NotBlank(message = "Senha is mandatory")
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
