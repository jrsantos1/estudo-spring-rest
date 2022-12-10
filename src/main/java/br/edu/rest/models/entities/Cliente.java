package br.edu.rest.models.entities;

public class Cliente {
	
	private int idade; 
	private String nome;
	private String cpf;
	public Cliente(int idade, String nome, String cpf) {
		super();
		this.idade = idade;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Cliente(){}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	

}
