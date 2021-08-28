package application.dto;

import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
public class UsuarioDTO {
	String nome;
	String email;
	TipoDeUsuario tipoUsuario;

	public UsuarioDTO(String nome, String email, TipoDeUsuario tipoUsuario) {
		super();
		this.nome = nome;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
	}

}
