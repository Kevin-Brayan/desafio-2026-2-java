package dev.kevin.desafio_2026_2_java.mapper;

import dev.kevin.desafio_2026_2_java.dto.SolicitacaoDTO;
import dev.kevin.desafio_2026_2_java.entity.*;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoMapper {

    public Solicitacao map(
            SolicitacaoDTO dto,
            Aluno aluno,
            Curso curso,
            TipoDocumento tipo,
            Status status) {

        Solicitacao solicitacao = new Solicitacao();

        solicitacao.setAluno(aluno);
        solicitacao.setCurso(curso);
        solicitacao.setTipoDocumento(tipo);
        solicitacao.setStatus(status);
        solicitacao.setPrioridade(dto.getPrioridade());
        solicitacao.setDataSolicitacao(dto.getDataSolicitacao());
        solicitacao.setDataAlteracao(dto.getDataAlteracao());

        return solicitacao;
    }

    public SolicitacaoDTO map(Solicitacao solicitacao) {
        SolicitacaoDTO solicitacaoDTO = new SolicitacaoDTO();

        solicitacaoDTO.setId(solicitacao.getId());
        solicitacaoDTO.setAlunoId(solicitacao.getAluno().getId());
        solicitacaoDTO.setCursoId(solicitacao.getCurso().getId());
        solicitacaoDTO.setTipoDocumentoId(solicitacao.getTipoDocumento().getId());
        solicitacaoDTO.setDataSolicitacao(solicitacao.getDataSolicitacao());
        solicitacaoDTO.setDataAlteracao(solicitacao.getDataAlteracao());
        solicitacaoDTO.setStatusId(solicitacao.getStatus().getId());
        solicitacaoDTO.setPrioridade(solicitacao.getPrioridade());


        solicitacaoDTO.setAlunoNome(solicitacao.getAluno().getNome());
        solicitacaoDTO.setCursoNome(solicitacao.getCurso().getNome());
        solicitacaoDTO.setTipoDocumentoNome(solicitacao.getTipoDocumento().getNome());
        solicitacaoDTO.setStatusNome(solicitacao.getStatus().getNome());

        return solicitacaoDTO;
    }
}