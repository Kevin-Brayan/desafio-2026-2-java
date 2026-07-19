package dev.kevin.desafio_2026_2_java.controller.api;

import dev.kevin.desafio_2026_2_java.dto.AlunoDTO;
import dev.kevin.desafio_2026_2_java.service.AlunoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO alunoRequest) {

        return alunoService.cadastrarAluno(alunoRequest);

    }

}
