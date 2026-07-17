package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

    Page<Solicitacao> findByAlunoNomeContainingIgnoreCase(
            String nome,
            Pageable pageable
    );

    Page<Solicitacao> findByCursoNomeContainingIgnoreCase(
            String nome,
            Pageable pageable
    );

    Page<Solicitacao> findByTipoDocumentoNomeContainingIgnoreCase(
            String nome,
            Pageable pageable
    );

    Page<Solicitacao> findByStatusNome(
            String nome,
            Pageable pageable
    );

    Page<Solicitacao> findByDataSolicitacaoBetween(
            LocalDateTime inicio,
            LocalDateTime fim,
            Pageable pageable
    );

}
