package dev.kevin.desafio_2026_2_java.controller;

import dev.kevin.desafio_2026_2_java.dto.StatusDTO;
import dev.kevin.desafio_2026_2_java.service.StatusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/cadastrar")
    public StatusDTO cadastrarStatus(@RequestBody StatusDTO statusRequest) {
        return statusService.cadastrarStatus(statusRequest);
    }
}
