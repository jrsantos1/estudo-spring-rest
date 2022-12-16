package br.edu.rest.config;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.rest.models.entities.Usuario;
import br.edu.rest.models.repositories.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    private UsuarioRepository usuarioRepository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository){
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                String token = recuperarToken(request);
                System.out.println(token);

                boolean valido = tokenService.isTokenValido(token);

                if (valido) {
                    autenticarCliente(token);
                }

                System.out.println(valido);

                filterChain.doFilter(request, response);
        
    }

    private String recuperarToken(HttpServletRequest request) {
        
        String token = request.getHeader("Authorization");

        if( token == null || token.isEmpty() || !token.startsWith("Bearer")){
            return null;
        }
    
        return token.substring(7, token.length());
    }

    private void autenticarCliente(String token) {
        Long id = tokenService.getIdUsuario(token);
        Usuario usuario = usuarioRepository.findById(id).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken (usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
