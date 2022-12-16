package br.edu.rest.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.edu.rest.models.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
    
    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String senha;
    
    
    public String gerarToken(Authentication authentication){
        
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();

        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
        .setIssuer(" API FUT MANAGER") // Aplicação que gerou o token 
        .setSubject(usuarioLogado.getId().toString()) // Usuario logado
        .setIssuedAt(hoje)
        .setExpiration(dataExpiracao)
        .signWith(SignatureAlgorithm.HS256, senha)
        .compact() 
        ;  // data de criação do token 
    }

    public boolean isTokenValido(String token){

        try {
            Jwts.parser().setSigningKey(this.senha).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        
        }
    }

    public Long getIdUsuario(String token){
        var claims = Jwts.parser().setSigningKey(this.senha).parseClaimsJws(token);
        System.out.println("Meu subject é: " + claims.getBody().getSubject());
        return Long.parseLong(claims.getBody().getSubject());
    }



}
