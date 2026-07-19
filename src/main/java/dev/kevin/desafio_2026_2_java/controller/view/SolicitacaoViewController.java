package dev.kevin.desafio_2026_2_java.controller.view;

import dev.kevin.desafio_2026_2_java.dto.SolicitacaoDTO;
import dev.kevin.desafio_2026_2_java.mapper.SolicitacaoMapper;
import dev.kevin.desafio_2026_2_java.repository.*;
import dev.kevin.desafio_2026_2_java.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/solicitacoes")
@RequiredArgsConstructor
public class SolicitacaoViewController {

    private final SolicitacaoRepository solicitacaoRepository;
    private final StatusRepository statusRepository;
    private final TipoDocRepository tipoDocRepository;

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    private final SolicitacaoMapper solicitacaoMapper;
    private final SolicitacaoService solicitacaoService;


    @GetMapping("/nova")
    public String novaSolicitacao(Model model) {

        model.addAttribute("solicitacao", new SolicitacaoDTO());

        model.addAttribute("alunos", alunoRepository.findAll());
        model.addAttribute("cursos", cursoRepository.findAll());
        model.addAttribute("tipos", tipoDocRepository.findAll());
        model.addAttribute("statusList", statusRepository.findAll());

        return "nova-solicitacao";
    }

    @PostMapping("/nova")
    public String salvarSolicitacao(@ModelAttribute SolicitacaoDTO dto) {

        solicitacaoService.cadastrarSolicitacao(dto);

        return "redirect:/solicitacoes";
    }



    @GetMapping
    public String listarSolicitacoes(
            @RequestParam(required = false) String aluno,
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String tipoDocumento,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate inicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fim,
            @RequestParam(defaultValue = "0") int page,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        
        Page<SolicitacaoDTO> pagina =
                solicitacaoRepository.findAll(pageable)
                        .map(solicitacaoMapper::map);

        model.addAttribute(
    "pagina",
                solicitacaoService.listarSolicitacao(
                        aluno,
                        curso,
                        status,
                        tipoDocumento,
                        inicio,
                        fim,
                        page,
                        10));

        model.addAttribute("statusList", statusRepository.findAll());
        model.addAttribute("tipos", tipoDocRepository.findAll());


        model.addAttribute("activePage", "solicitacoes");

        return "solicitacoes";
    }
}
