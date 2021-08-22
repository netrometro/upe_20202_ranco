package application.dto;

import java.util.List;

import application.models.Evento;
import lombok.Data;

@Data
public class eventoDTO {
	private String descricao;
	private boolean status;

	public eventoDTO(Evento evento) {
		this.descricao = evento.getDescricao();
		this.status = evento.isStatus();
	}
	

}
