package dev.kevin.desafio_2026_2_java.controller;

import dev.kevin.desafio_2026_2_java.dto.CursoDTO;
import dev.kevin.desafio_2026_2_java.service.CursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/cadastrar")
    public CursoDTO cadastrarCurso(@RequestBody CursoDTO cursoDTO) {

        return cursoService.cadastrarCurso(cursoDTO);

    }
}
