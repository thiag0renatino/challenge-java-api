package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.MotoDTO;
import com.fiap.challenge_api.dto.PosicaoDTO;
import com.fiap.challenge_api.dto.PosicaoResponseDTO;
import com.fiap.challenge_api.mapper.MotoMapper;
import com.fiap.challenge_api.mapper.PosicaoMapper;
import com.fiap.challenge_api.model.Moto;
import com.fiap.challenge_api.model.Posicao;
import com.fiap.challenge_api.repository.MotoRepository;
import com.fiap.challenge_api.repository.PatioRepository;
import com.fiap.challenge_api.repository.PosicaoRepository;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosicaoService {

    @Autowired
    private PosicaoRepository repository;

    @Autowired
    private MotoRepository motoRepository;

    @Autowired
    private PatioRepository patioRepository;

    @Autowired
    private PosicaoMapper mapper;

    @Autowired
    private MotoMapper motoMapper;

    @Cacheable("posicoes")
    public List<PosicaoResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public List<PosicaoDTO> findByMotoId(Long motoId){
        return repository.findByMoto_IdMoto(motoId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<PosicaoResponseDTO> findTop10ByOrderByDataHoraDesc() {
        return repository.findTop10ByOrderByDataHoraDesc()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public List<PosicaoResponseDTO> buscarHistoricoDaMoto(Long motoId) {
        return repository.buscarHistoricoDaMoto(motoId)
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public List<PosicaoResponseDTO> findPosicoesDeMotosRevisao() {
        return repository.findPosicoesDeMotosRevisao()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    public List<PosicaoDTO> findByPatioId(Long patioId) {
        return repository.findByPatioIdPatio(patioId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MotoDTO buscarMotoPorIdPosicao(Long posicaoId) {
        Posicao posicao = repository.findById(posicaoId)
                .orElseThrow(() -> new ResourceNotFoundException(posicaoId));

        Moto moto = posicao.getMoto();
        return motoMapper.toDTO(moto);
    }

    @CacheEvict(value = "posicoes", allEntries = true)
    public PosicaoDTO update(Long id, PosicaoDTO dto){
        Posicao posicaoExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        posicaoExist.setXPos(dto.getXPos());
        posicaoExist.setYPos(dto.getYPos());
        posicaoExist.setDataHora(dto.getDataHora());

        if (dto.getIdMoto() != null) {
            posicaoExist.setMoto(motoRepository.findById(dto.getIdMoto())
                    .orElseThrow(() -> new ResourceNotFoundException(dto.getIdMoto())));
        }

        if (dto.getIdPatio() != null) {
            posicaoExist.setPatio(patioRepository.findById(dto.getIdPatio())
                    .orElseThrow(() -> new ResourceNotFoundException(dto.getIdPatio())));
        }

        Posicao posicaoAtt = repository.save(posicaoExist);
        return mapper.toDTO(posicaoAtt);
    }

    @CacheEvict(value = "posicoes", allEntries = true)
    public PosicaoDTO insert(PosicaoDTO dto){
        Posicao posicao = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(posicao));
    }

    @CacheEvict(value = "posicoes", allEntries = true)
    public void delete(Long id){
        Posicao posicao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(posicao);
    }
}
