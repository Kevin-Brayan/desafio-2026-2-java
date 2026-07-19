package dev.kevin.desafio_2026_2_java.controller.view;

import dev.kevin.desafio_2026_2_java.service.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final SolicitacaoService solicitacaoService ;

    @GetMapping
    public String dashboard(Model model) {

        model.addAttribute("status", solicitacaoService.contarPorStatus());
        model.addAttribute("media", solicitacaoService.mediaEmissaoHoras());
        model.addAttribute("documentos", solicitacaoService.documentosMaisSolicitados());

        model.addAttribute("activePage", "dashboard");

        return "dashboard";
    }

}
