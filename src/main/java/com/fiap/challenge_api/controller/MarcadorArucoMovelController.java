package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MarcadorArucoMovelDTO;
import com.fiap.challenge_api.service.MarcadorArucoMovelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcadores-moveis")
public class MarcadorArucoMovelController {

    @Autowired
    private MarcadorArucoMovelService service;

    @GetMapping
    public ResponseEntity<List<MarcadorArucoMovelDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcadorArucoMovelDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/por-moto")
    public ResponseEntity<MarcadorArucoMovelDTO> findByMotoId(@RequestParam Long idMoto) {
        return ResponseEntity.ok(service.findByMotoId(idMoto));
    }

    @GetMapping("/por-codigo")
    public ResponseEntity<MarcadorArucoMovelDTO> findByCodigoAruco(@RequestParam String codigoAruco) {
        return ResponseEntity.ok(service.findByCodigoAruco(codigoAruco));
    }

    @PostMapping
    public ResponseEntity<MarcadorArucoMovelDTO> insert(@RequestBody @Valid MarcadorArucoMovelDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcadorArucoMovelDTO> update(@PathVariable Long id, @RequestBody @Valid MarcadorArucoMovelDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
