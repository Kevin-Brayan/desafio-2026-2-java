package dev.kevin.desafio_2026_2_java.entity;

import dev.kevin.desafio_2026_2_java.enums.Prioridade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao")
@Getter
@Setter
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoDocumento tipo;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataAlteracao;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
}
