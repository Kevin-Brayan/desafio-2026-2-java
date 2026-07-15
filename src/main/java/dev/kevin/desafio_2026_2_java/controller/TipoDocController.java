package dev.kevin.desafio_2026_2_java.controller;

import dev.kevin.desafio_2026_2_java.dto.TipoDocDTO;
import dev.kevin.desafio_2026_2_java.service.TipoDocService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoDoc")
public class TipoDocController {

    private final TipoDocService tipoDocService;

    public TipoDocController(TipoDocService tipoDocService) {
        this.tipoDocService = tipoDocService;
    }

    @PostMapping("/cadastrar")
    public TipoDocDTO cadastrarTipoDoc(@RequestBody TipoDocDTO tipoDocRequest) {
        return tipoDocService.cadastrarTipoDoc(tipoDocRequest);
    }

}
