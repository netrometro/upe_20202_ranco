package application.dto;

import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
public class PsicologoDTO extends UsuarioDTO {
	
	private String crp;

	public PsicologoDTO(String nome, String email, TipoDeUsuario tipoUsuario, String crp) {
		super(nome, email, tipoUsuario);
		this.crp = crp;
	}	

}
