package application.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import application.models.abstracts.DbEntity;
import lombok.Data;

@Data
@Entity
public class Medicacao extends DbEntity{
		
	private String nome;
	private String descricao;
	private String observacao;
	private int intervalo;
	private LocalDateTime ultimaDosagem;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonBackReference
	private Paciente usuario;

	protected Medicacao() {}
	
	public Medicacao(String nome, String posologia) {
		super();
		this.nome = nome;
		this.descricao = posologia;
	}

	public Medicacao(String nome, String posologia, Paciente usuario) {
		super();
		this.nome = nome;
		this.descricao = posologia;
		this.usuario = usuario;
	}

}
