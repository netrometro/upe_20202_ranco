package application.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import application.models.abstracts.DbEntity;
import application.models.enums.Categoria;
import application.models.enums.Motivo;
import lombok.Data;

@Data
@Entity
public class Evento extends DbEntity {
	
	@NotBlank (message = "Titulo é um campo obrigatório")
	private String titulo;
	private Date data;
	private String local;
	private String pessoaEnvolvida;
	private String expectativa;	
	@NotBlank (message = "Descrição é um campo obrigatório")
	private String descricao;
	private String pontoMelhoria;
	private String feedback;
	private boolean status;
	
	@NotBlank (message = "Categoria é um campo obrigatório")
	private Categoria categoria;
	@NotBlank (message = "Movico é um campo obrigatório")
	private Motivo motivo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
	private List<Sentimento> sentimentos;
	

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@JsonBackReference
	private Paciente usuario;
	

	public Evento() {
	}

	public Evento(String titulo, Date data, String local, String expectativa, String pessoaEnvolvida,String descricao, Categoria categoria, 
			String pontoMelhoria, String feedback, boolean status, Motivo motivo, Paciente usuario) {
		super();
		this.titulo = titulo;
		this.data = data;
		this.local = local;
		this.expectativa = expectativa;
		this.pessoaEnvolvida = pessoaEnvolvida;
		this.descricao = descricao;
		this.categoria = categoria;
		this.pontoMelhoria = pontoMelhoria;
		this.feedback = feedback;
		this.status = status;
		this.motivo = motivo;
		this.usuario = usuario;
	}

}