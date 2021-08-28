package application.dto;

import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {
	long id;
	String nome;
	String email;
	TipoDeUsuario tipoUsuario;

	public UsuarioDTO(long id, String nome, String email, TipoDeUsuario tipoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
	}

}
