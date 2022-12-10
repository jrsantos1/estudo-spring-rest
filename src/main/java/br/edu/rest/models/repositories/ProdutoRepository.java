package br.edu.rest.models.repositories;

import org.springframework.data.repository.CrudRepository;

import br.edu.rest.models.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
}
