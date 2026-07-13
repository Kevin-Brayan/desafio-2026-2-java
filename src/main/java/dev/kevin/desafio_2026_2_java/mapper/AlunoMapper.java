package dev.kevin.desafio_2026_2_java.mapper;

import dev.kevin.desafio_2026_2_java.dto.AlunoDTO;
import dev.kevin.desafio_2026_2_java.entity.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public Aluno map(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        aluno.setId(alunoDTO.getId());
        aluno.setNome(alunoDTO.getNome());
        aluno.setSolicitacoes(alunoDTO.getSolicitacoes());
        aluno.setAtivo(alunoDTO.isAtivo());

        return aluno;
    }

    public AlunoDTO map(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();

        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setSolicitacoes(aluno.getSolicitacoes());
        alunoDTO.setAtivo(aluno.isAtivo());

        return alunoDTO;
    }
}
