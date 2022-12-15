package br.edu.rest.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.rest.models.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
     Optional<Usuario> findByEmail(String email);

}
