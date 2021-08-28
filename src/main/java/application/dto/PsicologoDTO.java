package application.dto;

import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
public class PsicologoDTO extends UsuarioDTO {
	
	private String crp;

	public PsicologoDTO(long id, String nome, String email, TipoDeUsuario tipoUsuario, String crp) {
		super(id, nome, email, tipoUsuario);
		this.crp = crp;
	}


}
