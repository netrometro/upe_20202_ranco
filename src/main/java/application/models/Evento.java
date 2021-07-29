package application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

import lombok.Data;

@Data
@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_evento;
	private Date data; 
	private String local; 
	private String pessoaEnvolvida; 
	private String testemunhas;
	private String expectativa;
	private String descricao;
	private int categoria; 
	private String motivo; 
	private String prova; 
	private String pontoMelhoria;
	private String solucao;
	private String feedback;
	private boolean status;
	private String recomendacao; 
	private String sentimentos;
	
	@ManyToOne	
	private Paciente usuario; 
	
	public Evento(Date data, String local, String pessoaEnvolvida, String testemunhas, String expectativa, String descricao, int categoria, 
			String motivo, String prova, String pontoMelhoria, String solucao, String feedback, boolean status, String recomendacao, String sentimentos){
		super();
		this.data = data;
		this.local = local;
		this.pessoaEnvolvida = pessoaEnvolvida;
		this.testemunhas = testemunhas;
		this.expectativa = expectativa;
		this.descricao = descricao; 
		this.categoria = categoria; 
		this.motivo = motivo;
		this.prova = prova;
		this.pontoMelhoria = pontoMelhoria;
		this.solucao = solucao;
		this.feedback = feedback;
		this.status = status;
		this.recomendacao = recomendacao;
		this.sentimentos = sentimentos; 
		
		
	}
	
	public Evento(Date data, String local, String pessoaEnvolvida, String testemunhas, String expectativa, String descricao, int categoria, 
			String motivo, String prova, String pontoMelhoria, String solucao, String feedback, boolean status, String recomendacao, String sentimentos, Paciente usuario){
		super();
		this.data = data;
		this.local = local;
		this.pessoaEnvolvida = pessoaEnvolvida;
		this.testemunhas = testemunhas;
		this.expectativa = expectativa;
		this.descricao = descricao; 
		this.categoria = categoria; 
		this.motivo = motivo;
		this.prova = prova;
		this.pontoMelhoria = pontoMelhoria;
		this.solucao = solucao;
		this.feedback = feedback;
		this.status = status;
		this.recomendacao = recomendacao;
		this.sentimentos = sentimentos;
		this.usuario = usuario;
		
		
	}


} 