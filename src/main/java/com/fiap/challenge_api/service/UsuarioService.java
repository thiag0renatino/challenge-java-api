package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.UsuarioDTO;
import com.fiap.challenge_api.mapper.UsuarioMapper;
import com.fiap.challenge_api.model.Usuario;
import com.fiap.challenge_api.repository.UsuarioRepository;
import com.fiap.challenge_api.service.exception.EmailNotFoundException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;

    public List<UsuarioDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public UsuarioDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(email));
        return mapper.toDTO(usuario);
    }



}
