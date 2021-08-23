package application.dto;

import java.util.ArrayList;
import java.util.List;

import application.models.Evento;
import application.models.Sentimento;
import application.models.enums.Categoria;
import application.models.enums.GrauSentimento;
import application.models.enums.Motivo;
import application.models.enums.TipoDeSentimento;
import lombok.Data;

@Data
public class dadosGraficoDTO {
	private List<Boolean> status = new ArrayList<Boolean>();
	private List<Categoria> categoria= new ArrayList<Categoria>();
	private List<Motivo> motivo= new ArrayList<Motivo>();
	
	private List<TipoDeSentimento> sentimentosTipos = new ArrayList<TipoDeSentimento>();
	private List<GrauSentimento> sentimentosGrau = new ArrayList<GrauSentimento>();
	
	public dadosGraficoDTO(List<Evento> eventos) {
		
		for(Evento e : eventos) {
			this.status.add(e.isStatus());
			this.categoria.add(e.getCategoria());
			this.motivo.add(e.getMotivo());
			for(Sentimento sen : e.getSentimentos()) {
				this.sentimentosTipos.add(sen.getTipoSentimento());
				this.sentimentosGrau.add(sen.getGrauSentimento());			
				}
			
		}
	}
	
	
	

}
