package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MarcadorFixoDTO;
import com.fiap.challenge_api.service.MarcadorFixoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcadores-fixos")
public class MarcadorFixoController {

    @Autowired
    private MarcadorFixoService service;

    @GetMapping
    public ResponseEntity<List<MarcadorFixoDTO>> findALl(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/por-patio/{patioId}")
    public ResponseEntity<List<MarcadorFixoDTO>> findByPatioId(@PathVariable Long patioId) {
        return ResponseEntity.ok(service.findByPatioId(patioId));
    }

    @GetMapping("/por-codigo")
    public ResponseEntity<MarcadorFixoDTO> findByCodigoAruco(@RequestParam String codigo) {
        return ResponseEntity.ok(service.findByCodigoAruco(codigo));
    }

    @PostMapping
    public ResponseEntity<MarcadorFixoDTO> insert(@RequestBody @Valid MarcadorFixoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
