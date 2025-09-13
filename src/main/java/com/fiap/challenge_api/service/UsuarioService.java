package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.UsuarioDTO;
import com.fiap.challenge_api.mapper.UsuarioMapper;
import com.fiap.challenge_api.model.Patio;
import com.fiap.challenge_api.model.Usuario;
import com.fiap.challenge_api.repository.PatioRepository;
import com.fiap.challenge_api.repository.UsuarioRepository;
import com.fiap.challenge_api.service.exception.EmailNotFoundException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    PatioRepository patioRepository;

    @Autowired
    private UsuarioMapper mapper;

    public List<UsuarioDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public UsuarioDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional(readOnly = true)
    public UsuarioDTO me(Principal principal) {
        return findByEmail(principal.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
    }

    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new EmailNotFoundException(email));
        return mapper.toDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario usuarioExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        usuarioExist.setIdUsuario(dto.getIdUsuario());
        usuarioExist.setNome(dto.getNome());
        usuarioExist.setEmail(dto.getEmail());
        usuarioExist.setStatus(dto.getStatus());

        if (dto.getPatioId() != null) {
            Patio patio = new Patio();
            patio.setIdPatio(dto.getPatioId());
            usuarioExist.setPatio(patio);
        }

        Usuario usuarioAtt = repository.save(usuarioExist);
        return mapper.toDTO(usuarioAtt);
    }

    public void delete(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(usuario);
    }
}
