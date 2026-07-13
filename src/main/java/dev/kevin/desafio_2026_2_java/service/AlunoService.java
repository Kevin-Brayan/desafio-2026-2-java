package dev.kevin.desafio_2026_2_java.service;

import dev.kevin.desafio_2026_2_java.dto.AlunoDTO;
import dev.kevin.desafio_2026_2_java.entity.Aluno;
import dev.kevin.desafio_2026_2_java.mapper.AlunoMapper;
import dev.kevin.desafio_2026_2_java.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoService(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    public AlunoDTO cadastrarAluno(AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.map(alunoDTO);
        alunoRepository.save(aluno);
        return alunoMapper.map(aluno);

    }

}
