package dev.kevin.desafio_2026_2_java.controller;


import dev.kevin.desafio_2026_2_java.config.TokenConfig;
import dev.kevin.desafio_2026_2_java.dto.auth.LoginRequest;
import dev.kevin.desafio_2026_2_java.dto.auth.RegisterRequest;
import dev.kevin.desafio_2026_2_java.entity.Usuario;
import dev.kevin.desafio_2026_2_java.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/login")
    public ResponseEntity login(
            @RequestBody LoginRequest request,
            HttpServletResponse response
    ) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        Usuario usuario = (Usuario) authentication.getPrincipal();
        String token = tokenConfig.gerarToken(usuario);

        ResponseCookie cookie = ResponseCookie.from("jwt", token)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(60 * 60)
                .sameSite("Lax")
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.ok().build();
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequest request) {

        Usuario novoUsuario = new Usuario();

        novoUsuario.setNome(request.nome());
        novoUsuario.setEmail(request.email());
        novoUsuario.setSenha(passwordEncoder.encode(request.senha()));

        usuarioRepository.save(novoUsuario);

        return ResponseEntity.ok().build();
    }

}
