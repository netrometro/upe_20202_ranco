package application.dto;

import java.util.ArrayList;
import java.util.List;

import application.models.Evento;
import application.models.Sentimento;
import application.models.enums.Categoria;
import lombok.Data;

@Data
public class eventoDTO {
	private String descricao;
	private boolean status;
	private Categoria categoria;
	private List<sentimentoDTO> sentimentos;

	public eventoDTO(Evento evento) {
		sentimentos = new ArrayList<>();
		this.descricao = evento.getDescricao();
		this.status = evento.isStatus();
		this.categoria = evento.getCategoria();
		this.sentimentos = gerarListaSentimentos(evento.getSentimentos());
	}
	
	public List<sentimentoDTO> gerarListaSentimentos(List<Sentimento> paramSentimentos){
		for(Sentimento e : paramSentimentos) {
			this.sentimentos.add(new sentimentoDTO(e));
		}
		return this.sentimentos;
	}

}
