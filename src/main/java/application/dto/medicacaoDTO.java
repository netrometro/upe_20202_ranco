package application.dto;

import java.util.List;

import application.models.Medicacao;
import lombok.Data;

@Data
public class medicacaoDTO {
	private String nome;

	public medicacaoDTO(Medicacao medicacao) {
		this.nome = medicacao.getNome();
	}
	

}
