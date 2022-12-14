package br.edu.rest.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.rest.models.entities.Produto;
import br.edu.rest.models.repositories.ProdutoRepository;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	@CacheEvict(value = "listaDeProdutos", allEntries = true)
	@Transactional
	public @ResponseBody Produto salvarProduto(@Valid Produto produto)
	{	
		produtoRepository.save(produto);
		return produto;
	}

	@GetMapping
	@Cacheable("listaDeProdutos")
	public Iterable<Produto> obterProdutos(){
		return produtoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoID(@PathVariable int id){
		return produtoRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	@Transactional
	public void deletarProduto(@PathVariable int id){
		produtoRepository.deleteById(id);
	}

	@GetMapping(path = "/pagina/{numeroPagina}")
	public Iterable<Produto> obterProdutosPorPagina(@PathVariable int numeroPagina){
		Pageable page = PageRequest.of(numeroPagina, 3);
		return produtoRepository.findAll(page);
	}

}
