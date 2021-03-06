package application.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import application.models.abstracts.Usuario;
import application.models.enums.TipoDeUsuario;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
//@ToString(callSuper = true)
public class Paciente extends Usuario {
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Evento> eventos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	@JsonManagedReference
	private List<Medicacao> medicacoes;
	
	//private ArrayList<Alarme> alarmes; 
	
//	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<String> anotações;
	
	public Paciente() {
		
	}
	
	public Paciente(String nome, String email, String senha, TipoDeUsuario tipoUsuario) {
		super(nome, email, senha, tipoUsuario);
	}

	
	
}
