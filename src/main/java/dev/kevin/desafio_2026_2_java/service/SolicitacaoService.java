package dev.kevin.desafio_2026_2_java.service;

import dev.kevin.desafio_2026_2_java.dto.*;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    public Page<SolicitacaoDTO> listarSolicitacao(String aluno, String curso, String status, String tipoDocumento, LocalDate inicioData, LocalDate fimData, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Solicitacao> pagina ;

        if (aluno != null && !aluno.isBlank()) {

            pagina = solicitacaoRepository
                    .findByAlunoNomeContainingIgnoreCase(aluno, pageable);

        } else if (curso != null && !curso.isBlank()) {

            pagina = solicitacaoRepository
                    .findByCursoNomeContainingIgnoreCase(curso, pageable);

        } else if (status != null && !status.isBlank()) {

            pagina = solicitacaoRepository
                    .findByStatusNome(status, pageable);

        } else if (tipoDocumento != null && !tipoDocumento.isBlank()) {

            pagina = solicitacaoRepository
                    .findByTipoDocumentoNomeContainingIgnoreCase(tipoDocumento, pageable);

        } else if (inicioData != null && fimData != null) {
            LocalDateTime inicio = inicioData.atStartOfDay();
            LocalDateTime fim = fimData.plusDays(1).atStartOfDay().minusNanos(1);

            pagina = solicitacaoRepository
                    .findByDataSolicitacaoBetween(inicio, fim, pageable);

        } else {

            pagina = solicitacaoRepository.findAll(pageable);

        }

        return pagina.map(solicitacaoMapper::map);

    }

    public List<StatusEstatisticaDTO> contarPorStatus() {
        List<Object[]> dados = solicitacaoRepository.contarPorStatus();

        return dados.stream()
                .map(obj -> new StatusEstatisticaDTO(
                        (String) obj[0],
                        (Long) obj[1]
                ))
                .toList();
    }

    public PeriodoEstatisticaDTO contarPorPeriodo(LocalDate inicioDate, LocalDate fimDate) {
        LocalDateTime inicio = inicioDate.atStartOfDay();
        LocalDateTime fim = fimDate.plusDays(1).atStartOfDay().minusNanos(1);

        PeriodoEstatisticaDTO periodoEstatisticaDTO = new PeriodoEstatisticaDTO();
        Long qtd = solicitacaoRepository.contarPorPeriodo(inicio, fim);

        periodoEstatisticaDTO.setInicio(inicio);
        periodoEstatisticaDTO.setFim(fim);
        periodoEstatisticaDTO.setQuantidade(qtd);

        return periodoEstatisticaDTO;
    }

    public List<DocumentoEstatisticaDTO> documentosMaisSolicitados() {

        return solicitacaoRepository.documentosMaisSolicitados().stream()
                .map(obj -> new DocumentoEstatisticaDTO(
                        (String) obj[0],
                        (Long) obj[1]
                ))
                .toList();

    }

    public SolicitacaoDTO alterarStatus(AlterarStatusDTO request) {
        Solicitacao solicitacao = solicitacaoRepository.findById(request.getSolicitacaoId())
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));

        Status novoStatus = statusRepository.findById(request.getStatusId())
                .orElseThrow(() -> new RuntimeException("Status não encontrado"));

        if (!novoStatus.getResponsavelId().equals(request.getResponsavelId())) {
            throw new RuntimeException("Responsável inválido");
        }

        String atual = solicitacao.getStatus().getNome();
        String novo = novoStatus.getNome();

        if (atual.equals("ABERTA") && novo.equals("EM_ANALISE")) {
            // transição válida
        }
        else if (atual.equals("EM_ANALISE") && novo.equals("APROVADA")) {
            // transição válida
        }
        else if (atual.equals("EM_ANALISE") && novo.equals("REPROVADA")) {
            // transição válida
        }
        else if (atual.equals("APROVADA") && novo.equals("EMITIDA")) {
            // transição válida
        }
        else {

            throw new RuntimeException("Transição inválida.");

        }

        solicitacao.setStatus(novoStatus);
        solicitacao.setDataAlteracao(LocalDateTime.now());

        solicitacaoRepository.save(solicitacao);

        return solicitacaoMapper.map(solicitacao);
    }

    public MediaDTO mediaEmissaoHoras() {
        Double media = solicitacaoRepository.mediaEmissaoHoras();

        return new MediaDTO(media);
    }

}
