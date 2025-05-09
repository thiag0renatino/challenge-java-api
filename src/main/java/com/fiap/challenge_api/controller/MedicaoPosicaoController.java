package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MedicaoPosicaoDTO;
import com.fiap.challenge_api.service.MedicaoPosicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicoes")
public class MedicaoPosicaoController {

    @Autowired
    MedicaoPosicaoService service;

    @GetMapping
    public ResponseEntity<List<MedicaoPosicaoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicaoPosicaoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/posicao/{id}")
    public ResponseEntity<List<MedicaoPosicaoDTO>> findByPosicaoIdPosicao(@PathVariable Long id) {
        List<MedicaoPosicaoDTO> medicoes = service.findByPosicaoIdPosicao(id);
        return ResponseEntity.ok(medicoes);
    }

    @GetMapping("/marcador/{id}")
    public ResponseEntity<List<MedicaoPosicaoDTO>> findByMarcadorFixoId(@PathVariable Long id) {
        List<MedicaoPosicaoDTO> medicoes = service.findByMarcadorFixoId(id);
        return ResponseEntity.ok(medicoes);
    }

    @GetMapping("/posicao/{id}/contagem")
    public ResponseEntity<Long> contarPorPosicao(@PathVariable Long id) {
        return ResponseEntity.ok(service.contarPorPosicao(id));
    }

    @PostMapping
    public ResponseEntity<MedicaoPosicaoDTO> insert(@RequestBody @Valid MedicaoPosicaoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
