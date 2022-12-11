package br.edu.rest.models.dto;

public record Endereco(
    String lagradouro, 
    String bairro, 
    String cep, 
    String cidade, 
    String uf, 
    String numero, 
    String complemento) {

}
