package dev.kevin.desafio_2026_2_java.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String home() {
        return "redirect:/dashboard";
    }
}
