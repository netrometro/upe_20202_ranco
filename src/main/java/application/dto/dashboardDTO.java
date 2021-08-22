package application.dto;

import java.util.ArrayList;
import java.util.List;

import application.models.Evento;
import application.models.Medicacao;
import application.models.Paciente;
import lombok.Data;

@Data
public class dashboardDTO {
	private String nome;
	private List<eventoDTO> eventos;
	private List<medicacaoDTO> medicacoes;
	
	public dashboardDTO() {
		
	}
	
	public dashboardDTO(Paciente paciente) {
		eventos = new ArrayList<eventoDTO>();
		medicacoes = new ArrayList<medicacaoDTO>();
		this.nome = paciente.getNome();
		this.eventos = gerarListaEventos(paciente.getEventos());
		this.medicacoes = gerarListaMedicacoes(paciente.getMedicacoes());
	}
	
	public List<eventoDTO> gerarListaEventos(List<Evento> eventos){
		for(Evento e : eventos) {
			this.eventos.add(new eventoDTO(e));
		}
		return this.eventos;
	}

	public List<medicacaoDTO> gerarListaMedicacoes(List<Medicacao> medicacao){
		for(Medicacao a : medicacao) {
			this.medicacoes.add(new medicacaoDTO(a));
		}
		return this.medicacoes;
	}
}
