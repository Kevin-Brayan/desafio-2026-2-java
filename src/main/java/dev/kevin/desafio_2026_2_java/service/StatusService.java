package dev.kevin.desafio_2026_2_java.service;

import dev.kevin.desafio_2026_2_java.dto.StatusDTO;
import dev.kevin.desafio_2026_2_java.entity.Status;
import dev.kevin.desafio_2026_2_java.mapper.StatusMapper;
import dev.kevin.desafio_2026_2_java.repository.StatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StatusService {

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public StatusService(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    public StatusDTO cadastrarStatus(@RequestBody StatusDTO statusRequest) {
        Status status = statusMapper.map(statusRequest);
        statusRepository.save(status);
        return statusMapper.map(status);
    }

}
