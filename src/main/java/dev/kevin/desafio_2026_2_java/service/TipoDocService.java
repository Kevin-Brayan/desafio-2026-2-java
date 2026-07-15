package dev.kevin.desafio_2026_2_java.service;

import dev.kevin.desafio_2026_2_java.dto.TipoDocDTO;
import dev.kevin.desafio_2026_2_java.entity.TipoDocumento;
import dev.kevin.desafio_2026_2_java.mapper.TipoDocMapper;
import dev.kevin.desafio_2026_2_java.repository.TipoDocRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TipoDocService {

    private final TipoDocRepository tipoDocRepository;
    private final TipoDocMapper tipoDocMapper;

    public TipoDocService(TipoDocRepository tipoDocRepository, TipoDocMapper tipoDocMapper) {
        this.tipoDocRepository = tipoDocRepository;
        this.tipoDocMapper = tipoDocMapper;
    }

    public TipoDocDTO cadastrarTipoDoc(@RequestBody TipoDocDTO tipoDocRequest) {
        TipoDocumento tipoDocumento = tipoDocMapper.map(tipoDocRequest);
        tipoDocRepository.save(tipoDocumento);
        return tipoDocMapper.map(tipoDocumento);
    }
}
