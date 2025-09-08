package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.MarcadorFixoDTO;
import com.fiap.challenge_api.dto.MarcadorFixoResponseDTO;
import com.fiap.challenge_api.mapper.MarcadorFixoMapper;
import com.fiap.challenge_api.model.MarcadorFixo;
import com.fiap.challenge_api.repository.MarcadorFixoRepository;
import com.fiap.challenge_api.service.exception.MarcadorNotFoundException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcadorFixoService {

    @Autowired
    private MarcadorFixoRepository repository;

    @Autowired
    private MarcadorFixoMapper mapper;

    public Page<MarcadorFixoResponseDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponseDTO);
    }

    public MarcadorFixoDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public MarcadorFixoResponseDTO findByIdResponse(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<MarcadorFixoResponseDTO> findByPatioId(Long patioId) {
        return repository.findByPatioIdPatio(patioId)
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public MarcadorFixoResponseDTO findByCodigoAruco(String codigoAruco) {
        MarcadorFixo marcador = repository.findByCodigoArucoIgnoreCase(codigoAruco)
                .orElseThrow(() -> new MarcadorNotFoundException(codigoAruco));
        return mapper.toResponseDTO(marcador);
    }

    public MarcadorFixoDTO insert(MarcadorFixoDTO dto) {
        MarcadorFixo marcadorFixo = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(marcadorFixo));
    }

    public void delete(Long id) {
        MarcadorFixo marcadorFixo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(marcadorFixo);
    }

}
