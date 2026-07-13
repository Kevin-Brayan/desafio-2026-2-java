package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
