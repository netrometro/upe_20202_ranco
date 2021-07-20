package com.example.models;

public class Medicacao {
	private String nome;
	private String posologia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public Medicacao(String nome, String posologia) {
		super();
		this.nome = nome;
		this.posologia = posologia;
	}

}
