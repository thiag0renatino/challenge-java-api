package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.PosicaoDTO;
import com.fiap.challenge_api.mapper.PosicaoMapper;
import com.fiap.challenge_api.model.Posicao;
import com.fiap.challenge_api.repository.PosicaoRepository;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicaoService {

    @Autowired
    private PosicaoRepository repository;

    @Autowired
    private PosicaoMapper mapper;

    public List<PosicaoDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<PosicaoDTO> findByMotoId(Long motoId){
        return repository.findByMoto_IdMoto(motoId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }


    public List<PosicaoDTO> findTop10ByOrderByDataHoraDesc() {
        return repository.findTop10ByOrderByDataHoraDesc()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<PosicaoDTO> buscarHistoricoDaMoto(Long motoId) {
        return repository.buscarHistoricoDaMoto(motoId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<PosicaoDTO> findPosicoesDeMotosIndisponiveis() {
        return repository.findPosicoesDeMotosIndisponiveis()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public PosicaoDTO insert(PosicaoDTO dto){
        Posicao posicao = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(posicao));
    }

    public void delete(Long id){
        Posicao posicao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(posicao);
    }
}
