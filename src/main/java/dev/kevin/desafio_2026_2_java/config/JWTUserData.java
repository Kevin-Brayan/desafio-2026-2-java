package dev.kevin.desafio_2026_2_java.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long userId, String email) {
}
