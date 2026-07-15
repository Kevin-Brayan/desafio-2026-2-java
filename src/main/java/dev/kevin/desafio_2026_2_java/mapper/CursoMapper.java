package dev.kevin.desafio_2026_2_java.mapper;

import dev.kevin.desafio_2026_2_java.dto.CursoDTO;
import dev.kevin.desafio_2026_2_java.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public Curso map(CursoDTO cursoDTO) {
        Curso curso = new Curso();

        curso.setId(cursoDTO.getId());
        curso.setNome(cursoDTO.getNome());

        return curso;
    }

    public CursoDTO map(Curso curso) {
        CursoDTO cursoDTO = new CursoDTO();

        cursoDTO.setId(curso.getId());
        cursoDTO.setNome(curso.getNome());

        return cursoDTO;

    }
}
