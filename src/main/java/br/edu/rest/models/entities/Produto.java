package br.edu.rest.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id; 

	@NotBlank
	String nome;

	@Min(value = 0)
	double preco; 

	@Min(value = 0)
	@Max(value = 1)
	double desconto;
	
	public Produto(@NotBlank String nome, @Min(0) double preco, @Min(0) @Max(1) double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

	public Produto(){}

	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	
	
}
