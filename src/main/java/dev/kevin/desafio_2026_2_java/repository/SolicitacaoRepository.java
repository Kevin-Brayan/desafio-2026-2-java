package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
