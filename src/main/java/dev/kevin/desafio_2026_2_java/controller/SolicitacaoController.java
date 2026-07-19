package dev.kevin.desafio_2026_2_java.controller;

import dev.kevin.desafio_2026_2_java.dto.*;
import dev.kevin.desafio_2026_2_java.dto.estatistica.DocumentoEstatisticaDTO;
import dev.kevin.desafio_2026_2_java.dto.estatistica.MediaDTO;
import dev.kevin.desafio_2026_2_java.dto.estatistica.PeriodoEstatisticaDTO;
import dev.kevin.desafio_2026_2_java.dto.estatistica.StatusEstatisticaDTO;
import dev.kevin.desafio_2026_2_java.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/solicitacao")
@RequiredArgsConstructor
public class SolicitacaoController {

    private final SolicitacaoService solicitacaoService;

//    Cadastrar Solicitações
    @PostMapping("/cadastrar")
    public SolicitacaoDTO cadastrarSolicitacao(@RequestBody SolicitacaoDTO solicitacaoRequest) {

        return solicitacaoService.cadastrarSolicitacao(solicitacaoRequest);

    }

//    Listar Solicitações
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

//    Consultar solcitações por status
    @GetMapping("/estatisticas/status")
    public List<StatusEstatisticaDTO> contarPorStatus() {
        return solicitacaoService.contarPorStatus();
    }

//    Consultar solicitações feitas num período de tempo
    @GetMapping("/estatisticas/periodo")
    public PeriodoEstatisticaDTO contarPorPeriodo(@RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        return solicitacaoService.contarPorPeriodo(inicio, fim);
    }

//    Consultar quais são os documentos mais solicitados
    @GetMapping("/estatisticas/documentos-mais-solicitados")
    public List<DocumentoEstatisticaDTO> documentosMaisSolicitados() {
        return solicitacaoService.documentosMaisSolicitados();
    }

    @GetMapping("/estatisticas/media")
    public MediaDTO mediaEmissaoHoras() {
        return solicitacaoService.mediaEmissaoHoras();
    }

//    Alterar status
    @PatchMapping("/status")
    public SolicitacaoDTO alterarStatus(@RequestBody AlterarStatusDTO request) {
        return solicitacaoService.alterarStatus(request);
    }



}
