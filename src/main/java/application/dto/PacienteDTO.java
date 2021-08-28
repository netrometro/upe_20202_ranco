package application.dto;

import java.util.List;

import application.models.Evento;
import application.models.Medicacao;
import application.models.enums.TipoDeUsuario;
import lombok.Data;

@Data
public class PacienteDTO extends UsuarioDTO {

	private List<Evento> eventos;
	private List<Medicacao> medicacoes;

	public PacienteDTO(long id, String nome, String email, TipoDeUsuario tipoUsuario, List<Evento> eventos,
			List<Medicacao> medicacoes) {
		super(id, nome, email, tipoUsuario);
		this.eventos = eventos;
		this.medicacoes = medicacoes;
	}

}
