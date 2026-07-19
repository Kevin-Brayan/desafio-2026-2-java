package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

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

    @Query("""
    SELECT s.status.nome, COUNT(s)
    FROM Solicitacao s
    GROUP BY s.status.nome
    """)
    List<Object[]> contarPorStatus();

    @Query("""
    SELECT COUNT(s)
    FROM Solicitacao s
    WHERE s.dataSolicitacao BETWEEN :inicio AND :fim
    """)
    Long contarPorPeriodo(LocalDateTime inicio, LocalDateTime fim);


    @Query("""
    SELECT s.tipoDocumento.nome, COUNT(s)
    FROM Solicitacao s
    GROUP BY s.tipoDocumento.nome
    ORDER BY COUNT(s) DESC
    """)
    List<Object[]> documentosMaisSolicitados();

    @Query("""
    SELECT AVG(TIMESTAMPDIFF(HOUR,
    s.dataSolicitacao,
    s.dataAlteracao))
    FROM Solicitacao s
    WHERE s.status.nome = 'EMITIDA'
    """)
    Double mediaEmissaoHoras();
}
