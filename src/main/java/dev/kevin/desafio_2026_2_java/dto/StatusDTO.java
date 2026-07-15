package dev.kevin.desafio_2026_2_java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO {

    private Long id;
    private String nome;
    private Long responsavelId;
    private boolean finalizaSolicitacao;
}
