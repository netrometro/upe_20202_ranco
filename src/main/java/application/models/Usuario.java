package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import application.models.enums.TipoDeUsuario;
import lombok.Data;
import lombok.ToString;

@Data
@MappedSuperclass
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_usuario;
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
