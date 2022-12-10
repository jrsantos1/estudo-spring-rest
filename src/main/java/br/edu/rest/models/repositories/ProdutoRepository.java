package br.edu.rest.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.edu.rest.models.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
	
}
