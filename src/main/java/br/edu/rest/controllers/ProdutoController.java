package br.edu.rest.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public @ResponseBody Produto salvarProduto(@Valid Produto produto)
	{	
		produtoRepository.save(produto);
		return produto;
	}

	@GetMapping
	public Iterable<Produto> obterProdutos(){
		return produtoRepository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoID(@PathVariable int id){
		return produtoRepository.findById(id);
	}

	@DeleteMapping(path = "/{id}")
	public void deletarProduto(@PathVariable int id){
		produtoRepository.deleteById(id);
	}

}
