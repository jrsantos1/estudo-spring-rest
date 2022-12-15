package br.edu.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.rest.config.TokenService;
import br.edu.rest.models.dto.FormLogin;
import br.edu.rest.models.dto.TokenDto;

@Controller
@RequestMapping("/auth")
public class AutenticacaoController {
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid FormLogin formLogin){
        
        UsernamePasswordAuthenticationToken dadosLogin = formLogin.converter();
        
        
        try {
            
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));

        } catch (AuthenticationException e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();

        }
    }
    
}
