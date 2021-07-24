package application.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Data
@Entity
public class Paciente extends Usuario {
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Evento> eventos;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Medicacao> medicacoes;
	
	//private ArrayList<Alarme> alarmes; 
	
//	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<String> anotações;
	
	public Paciente() {
		
	}
	
	public Paciente(int id_usuario, String nome, String email, String senha, int tipoUsuario) {
		super(id_usuario, nome, email, senha, tipoUsuario);
	}
	
	
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


	/*
	public ArrayList<String> getAnotações() {
		return anotações;
	}

	public void setAnotações(ArrayList<String> anotações) {
		this.anotações = anotações;
	}*/
	
	
	
}
