package application.models;

import java.util.ArrayList;

public class Paciente extends Usuario {
	private ArrayList<Evento> eventos;
	private ArrayList<Medicacao> medicacoes;
	//private ArrayList<Alarme> alarmes; 
	private ArrayList<String> anotações;
	
	private void conectarMedico() {
		
	}
	
	private void registrarEvento() {
		
	}
	
	private void escreverFeedBack() {
		
	}
	
	private void registrarMedicacao() {
		
	}
	
	public void vizualizarDashboard() {
		
	}
	
	private void configurarAlarme() {
		
	}

	public ArrayList<String> getAnotações() {
		return anotações;
	}

	public void setAnotações(ArrayList<String> anotações) {
		this.anotações = anotações;
	}
	
	
	
}
