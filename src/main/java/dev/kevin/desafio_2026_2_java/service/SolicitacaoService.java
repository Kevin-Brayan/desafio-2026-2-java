package dev.kevin.desafio_2026_2_java.service;

import dev.kevin.desafio_2026_2_java.dto.SolicitacaoDTO;
import dev.kevin.desafio_2026_2_java.entity.*;
import dev.kevin.desafio_2026_2_java.entity.Solicitacao;
import dev.kevin.desafio_2026_2_java.mapper.SolicitacaoMapper;
import dev.kevin.desafio_2026_2_java.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SolicitacaoService {

    private final SolicitacaoRepository solicitacaoRepository;
    private final SolicitacaoMapper solicitacaoMapper;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;
    private final TipoDocRepository tipoDocRepository;
    private final StatusRepository statusRepository;



    public SolicitacaoDTO cadastrarSolicitacao(@RequestBody SolicitacaoDTO solicitacaoRequest) {

        Aluno aluno = alunoRepository.findById(solicitacaoRequest.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(solicitacaoRequest.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        TipoDocumento tipoDocumento= tipoDocRepository.findById(solicitacaoRequest.getTipoDocumentoId())
                .orElseThrow(() -> new RuntimeException("Tipo de documento inexistente"));

        Status status = statusRepository.findById(solicitacaoRequest.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status inexistente"));


        Solicitacao solicitacao = solicitacaoMapper.map(solicitacaoRequest, aluno, curso, tipoDocumento, status);


        solicitacao.setDataSolicitacao(LocalDateTime.now());
        solicitacao.setDataAlteracao(LocalDateTime.now());


        solicitacaoRepository.save(solicitacao);

        return solicitacaoMapper.map(solicitacao);

    }

    public Page<SolicitacaoDTO> listarSolicitacao(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Solicitacao> pagina = solicitacaoRepository.findAll(pageable);

        return pagina.map(solicitacaoMapper::map);

    }

}
