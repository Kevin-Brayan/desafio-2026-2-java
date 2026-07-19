package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<UserDetails> findUserByEmail(String username);
}
