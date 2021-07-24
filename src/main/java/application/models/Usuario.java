package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	private String nome;
	private String email;
	private String senha;
	private int tipoUsuario;

	protected Usuario() {}
	
	public Usuario(int id_usuario, String nome, String email, String senha, int tipoUsuario) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}
}
