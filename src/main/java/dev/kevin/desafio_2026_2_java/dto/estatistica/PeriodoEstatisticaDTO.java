package dev.kevin.desafio_2026_2_java.dto.estatistica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodoEstatisticaDTO {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private Long quantidade;

}
