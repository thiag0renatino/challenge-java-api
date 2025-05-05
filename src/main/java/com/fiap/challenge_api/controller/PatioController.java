package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.PatioDTO;
import com.fiap.challenge_api.service.PatioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patios")
public class PatioController {

    @Autowired
    private PatioService service;

    @GetMapping
    public ResponseEntity<List<PatioDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/com-motos")
    public ResponseEntity<List<PatioDTO>> findPatiosComMotos() {
        List<PatioDTO> patios = service.findPatiosComMotos();
        return ResponseEntity.ok(patios);
    }

    @PostMapping
    public ResponseEntity<PatioDTO> insert(@RequestBody @Valid PatioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatioDTO> update(@PathVariable Long id, @RequestBody @Valid PatioDTO dto){
        return ResponseEntity.ok(service.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
