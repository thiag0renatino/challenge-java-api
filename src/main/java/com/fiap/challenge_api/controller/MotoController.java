package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MotoDTO;
import com.fiap.challenge_api.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService service;

    @GetMapping
    public ResponseEntity<List<MotoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<MotoDTO>> findByPlaca(@RequestParam String placa){
        return ResponseEntity.ok(service.findByPlaca(placa));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<MotoDTO>> findByStatus(@PathVariable String status){
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @PostMapping
    public ResponseEntity<MotoDTO> insert(@RequestBody @Valid MotoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @RequestBody @Valid MotoDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
