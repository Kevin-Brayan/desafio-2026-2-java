package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
