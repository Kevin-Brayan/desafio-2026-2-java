package dev.kevin.desafio_2026_2_java.controller;

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

    @GetMapping("/cadastrar")
    public String cadastrarAluno() {
        return "Testando cadastro aluno";
    }

    @PostMapping("/cadastrar")
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO alunoRequest) {
        AlunoDTO alunoDTO = alunoService.cadastrarAluno(alunoRequest);

        return alunoDTO;
    }

}
