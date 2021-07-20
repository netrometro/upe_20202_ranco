/**
 * 
 */
package models;

import java.util.Date;

/**
 * @author clara
 * Criação da classe Evento
 */
public class Evento {
	
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
	
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getPessoaEnvolvida() {
		return pessoaEnvolvida;
	}
	
	public void setPessoaEnvolvida(String pessoaEnvolvida) {
		this.pessoaEnvolvida = pessoaEnvolvida;
	}
	
	public String getTestemunhas() {
		return testemunhas;
	}
	
	public void setTestemunhas(String testemunhas) {
		this.testemunhas = testemunhas;
	}
	
	public String getExpectativa() {
		return expectativa;
	}
	
	public void setExpectativa(String expectativa) {
		this.expectativa = expectativa;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public String getProva() {
		return prova;
	}
	
	public void setProva(String prova) {
		this.prova = prova;
	}
	
	public String getPontoMelhoria() {
		return pontoMelhoria;
	}
	
	public void setPontoMelhoria(String pontoMelhoria) {
		this.pontoMelhoria = pontoMelhoria;
	}
	
	public String getSolucao() {
		return solucao;
	}
	
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}
	
	public String getFeedback() {
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getRecomendacao() {
		return recomendacao;
	}
	
	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}
	
	public String getSentimentos() {
		return sentimentos;
	}
	
	public void setSentimentos(String sentimentos) {
		this.sentimentos = sentimentos;
	} 	
}