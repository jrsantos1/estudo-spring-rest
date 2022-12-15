package br.edu.rest.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.rest.models.dto.FormLogin;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {
    
    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid FormLogin formLogin){
        System.out.println(formLogin.getEmail());
        System.out.println(formLogin.getSenha());

        return ResponseEntity.ok().build();

    }
    
}
