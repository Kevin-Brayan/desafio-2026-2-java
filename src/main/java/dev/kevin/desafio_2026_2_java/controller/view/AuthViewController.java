package dev.kevin.desafio_2026_2_java.controller.view;

import dev.kevin.desafio_2026_2_java.controller.api.AuthController;
import dev.kevin.desafio_2026_2_java.dto.auth.LoginRequest;
import dev.kevin.desafio_2026_2_java.dto.auth.RegisterRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthViewController {

    private final AuthController authController;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String loginForm(LoginRequest request, HttpServletResponse response) {
        authController.autenticar(request, response);
        return "redirect:/dashboard";
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String registerForm(RegisterRequest request) {
        authController.registrarUsuario(request);
        return "redirect:/auth/login";
    }
}
