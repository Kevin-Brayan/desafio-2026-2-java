package dev.kevin.desafio_2026_2_java.dto;

import dev.kevin.desafio_2026_2_java.entity.Aluno;
import dev.kevin.desafio_2026_2_java.entity.Curso;
import dev.kevin.desafio_2026_2_java.entity.Status;
import dev.kevin.desafio_2026_2_java.entity.TipoDocumento;
import dev.kevin.desafio_2026_2_java.enums.Prioridade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoDTO {

    private Long id;

    private Long alunoId;

    private Long cursoId;

    private Long tipoDocumentoId;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataAlteracao;

    private Long statusId;

    private Prioridade prioridade;
}
