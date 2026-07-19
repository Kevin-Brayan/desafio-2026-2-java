package dev.kevin.desafio_2026_2_java.dto;

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



    private String alunoNome;
    private String cursoNome;
    private String tipoDocumentoNome;
    private String statusNome;
}
