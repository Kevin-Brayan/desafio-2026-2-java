package dev.kevin.desafio_2026_2_java.mapper;

import dev.kevin.desafio_2026_2_java.dto.TipoDocDTO;
import dev.kevin.desafio_2026_2_java.entity.TipoDocumento;
import org.springframework.stereotype.Component;

@Component
public class TipoDocMapper {
    public TipoDocumento map(TipoDocDTO tipoDocDTO) {
        TipoDocumento tipoDocumento = new TipoDocumento();

        tipoDocumento.setId(tipoDocDTO.getId());
        tipoDocumento.setNome(tipoDocDTO.getNome());

        return tipoDocumento;
    }

    public TipoDocDTO map(TipoDocumento tipoDocumento) {
        TipoDocDTO tipoDocDTO = new TipoDocDTO();

        tipoDocDTO.setId(tipoDocumento.getId());
        tipoDocDTO.setNome(tipoDocumento.getNome());

        return tipoDocDTO;
    }
}
