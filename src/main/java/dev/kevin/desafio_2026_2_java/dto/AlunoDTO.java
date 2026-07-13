package dev.kevin.desafio_2026_2_java.dto;

import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private Set<Solicitacao> solicitacoes;
    private boolean ativo;

}
