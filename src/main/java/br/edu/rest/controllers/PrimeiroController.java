package br.edu.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.rest.models.entities.Cliente;

@RestController
public class PrimeiroController {

    @RequestMapping(path = {"/", "/home", "/outro"})
    public Cliente ola(){
        return new Cliente(28, "Jhonatan", "45179292808");
    }
}
