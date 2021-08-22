package application.dto;

import java.util.List;

import application.models.Evento;
import application.models.Medicacao;
import application.models.Paciente;
import lombok.Data;

@Data
public class dashboardDTO {
	private String nome;
	private List<Evento> eventos;
	private List<Medicacao> medicacoes;
	
	public dashboardDTO() {
		
	}
	
	public dashboardDTO(Paciente paciente) {
		this.nome = paciente.getNome();
		this.eventos = paciente.getEventos();
		this.medicacoes = paciente.getMedicacoes();
	}
	}
