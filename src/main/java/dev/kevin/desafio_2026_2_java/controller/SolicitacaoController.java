package dev.kevin.desafio_2026_2_java.controller;

import dev.kevin.desafio_2026_2_java.dto.SolicitacaoDTO;
import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import dev.kevin.desafio_2026_2_java.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/solicitacao")
@RequiredArgsConstructor
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;

    @PostMapping("/cadastrar")
    public SolicitacaoDTO cadastrarSolicitacao(@RequestBody SolicitacaoDTO solicitacaoRequest) {

        return solicitacaoService.cadastrarSolicitacao(solicitacaoRequest);

    }

    @GetMapping("/listar")
    public Page<SolicitacaoDTO> listarSolicitacao(
                @RequestParam(required = false) String aluno,
                @RequestParam(required = false) String curso,
                @RequestParam(required = false) String status,
                @RequestParam(required = false) String tipoDocumento,
                @RequestParam(required = false) LocalDate inicio,
                @RequestParam(required = false) LocalDate fim,
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size
            ){
        return solicitacaoService.listarSolicitacao(aluno, curso, status, tipoDocumento, inicio, fim, page, size);
    }
}
