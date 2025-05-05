package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.PosicaoDTO;
import com.fiap.challenge_api.service.PosicaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    @Autowired
    private PosicaoService service;

    @GetMapping
    public ResponseEntity<List<PosicaoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/moto/{motoId}")
    public ResponseEntity<List<PosicaoDTO>> findByMotoId(@PathVariable Long motoId) {
        return ResponseEntity.ok(service.findByMotoId(motoId));
    }

    @GetMapping("/ultimas")
    public ResponseEntity<List<PosicaoDTO>> findTop10ByOrderByDataHoraDesc() {
        return ResponseEntity.ok(service.findTop10ByOrderByDataHoraDesc());
    }

    @GetMapping("/historico/{motoId}")
    public ResponseEntity<List<PosicaoDTO>> buscarHistoricoDaMoto(@PathVariable Long motoId) {
        return ResponseEntity.ok(service.buscarHistoricoDaMoto(motoId));
    }

    @GetMapping("/indisponiveis")
    public ResponseEntity<List<PosicaoDTO>> findPosicoesDeMotosIndisponiveis() {
        return ResponseEntity.ok(service.findPosicoesDeMotosIndisponiveis());
    }

    @PostMapping
    public ResponseEntity<PosicaoDTO> insert(@RequestBody @Valid PosicaoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @RequestBody @Valid PosicaoDTO dto){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
