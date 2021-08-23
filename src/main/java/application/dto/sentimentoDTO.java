package application.dto;

import application.models.Sentimento;
import application.models.enums.GrauSentimento;
import application.models.enums.TipoDeSentimento;
import lombok.Data;

@Data
public class sentimentoDTO {
	private TipoDeSentimento tipoSentimento;
	private GrauSentimento grauSentimento;
	
	
	public sentimentoDTO(Sentimento sentimento) {
		this.tipoSentimento = sentimento.getTipoSentimento();
		this.grauSentimento = sentimento.getGrauSentimento();
	}
}
