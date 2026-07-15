package dev.kevin.desafio_2026_2_java.service;

import dev.kevin.desafio_2026_2_java.dto.CursoDTO;
import dev.kevin.desafio_2026_2_java.entity.Curso;
import dev.kevin.desafio_2026_2_java.mapper.CursoMapper;
import dev.kevin.desafio_2026_2_java.repository.CursoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    public CursoDTO cadastrarCurso(@RequestBody CursoDTO cursoRequest) {
        Curso curso = cursoMapper.map(cursoRequest);
        cursoRepository.save(curso);
        return cursoMapper.map(curso);
    }
}
