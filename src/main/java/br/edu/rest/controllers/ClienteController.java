package br.edu.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.rest.models.entities.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping("/{id}")
    public Cliente get(@PathVariable int id) {
    	if (id == 1){
            return new Cliente(12, "Jhonatan Ribeiro", "45179292808");
        }

        return new Cliente();

    }
    
//    @GetMapping
//    public Cliente get2(@RequestParam(name = "id", defaultValue = "1") int id) {
//    	return new Cliente(12, "Jhonatan Ribeiro", "45179292808");
//    }
    
    
}
