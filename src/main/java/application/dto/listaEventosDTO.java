package application.dto;

import java.util.ArrayList;
import java.util.List;

import application.models.Evento;

public class listaEventosDTO {
	public List<eventoDTO> eventos;
	
	public listaEventosDTO(List<Evento> eventos) {
		this.eventos = new ArrayList<eventoDTO>();
		this.eventos = gerarListaEventos(eventos);
	}
	
	public List<eventoDTO> gerarListaEventos(List<Evento> eventos){
		for(Evento e : eventos) {
			this.eventos.add(new eventoDTO(e));
		}
		return this.eventos;
	}
}
