package dev.kevin.desafio_2026_2_java.mapper;

import dev.kevin.desafio_2026_2_java.dto.StatusDTO;
import dev.kevin.desafio_2026_2_java.entity.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public Status map(StatusDTO statusDTO) {
        Status status = new Status();

        status.setId(statusDTO.getId());
        status.setNome(statusDTO.getNome());
        status.setResponsavelId(statusDTO.getResponsavelId());
        status.setFinalizaSolicitacao(statusDTO.isFinalizaSolicitacao());

        return status;
    }

    public StatusDTO map(Status status) {
        StatusDTO statusDTO = new StatusDTO();

        statusDTO.setId(status.getId());
        statusDTO.setNome(status.getNome());
        statusDTO.setResponsavelId(status.getResponsavelId());
        statusDTO.setFinalizaSolicitacao(status.isFinalizaSolicitacao());

        return statusDTO;
    }

}
