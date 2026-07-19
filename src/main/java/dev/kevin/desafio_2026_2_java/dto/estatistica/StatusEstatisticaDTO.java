package dev.kevin.desafio_2026_2_java.dto.estatistica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusEstatisticaDTO {

    private String status;
    private Long quantidade;

}
