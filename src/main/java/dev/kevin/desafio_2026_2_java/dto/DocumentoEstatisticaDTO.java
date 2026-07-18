package dev.kevin.desafio_2026_2_java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoEstatisticaDTO {
    private String doocumento;
    private Long quantidade;
}
