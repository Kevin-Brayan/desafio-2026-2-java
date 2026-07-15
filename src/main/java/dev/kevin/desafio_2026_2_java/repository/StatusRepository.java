package dev.kevin.desafio_2026_2_java.repository;

import dev.kevin.desafio_2026_2_java.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
