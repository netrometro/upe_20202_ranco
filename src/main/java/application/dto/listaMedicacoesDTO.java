package application.dto;

import java.util.ArrayList;
import java.util.List;

import application.models.Evento;
import application.models.Medicacao;

public class listaMedicacoesDTO {
		public List<medicacaoDTO> medicacoes;
		
		public listaMedicacoesDTO(List<Medicacao> medicacoes) {
			this.medicacoes = new ArrayList<medicacaoDTO>();
			this.medicacoes = gerarListaMedicacoes(medicacoes);
		}
		
		public List<medicacaoDTO> gerarListaMedicacoes(List<Medicacao> medicacao){
			for(Medicacao a : medicacao) {
				this.medicacoes.add(new medicacaoDTO(a));
			}
			return this.medicacoes;
		}
	}

