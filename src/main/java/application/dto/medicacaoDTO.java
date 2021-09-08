package application.dto;

import java.util.List;

import application.models.Medicacao;
import lombok.Data;

@Data
public class medicacaoDTO {
	long id;
	private String nome;
	private int intervalo;

	public medicacaoDTO(Medicacao medicacao) {
		this.id = medicacao.getId();
		this.nome = medicacao.getNome();
		this.intervalo = medicacao.getIntervalo();
	}
	

}
