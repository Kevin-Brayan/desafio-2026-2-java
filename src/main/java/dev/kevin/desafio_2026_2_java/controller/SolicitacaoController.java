package dev.kevin.desafio_2026_2_java.controller;

import dev.kevin.desafio_2026_2_java.dto.SolicitacaoDTO;
import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import dev.kevin.desafio_2026_2_java.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitacao")
@RequiredArgsConstructor
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;

    @PostMapping("/cadastrar")
    public SolicitacaoDTO cadastrarSolicitacao(@RequestBody SolicitacaoDTO solicitacaoRequest) {

        return solicitacaoService.cadastrarSolicitacao(solicitacaoRequest);

    }
}
