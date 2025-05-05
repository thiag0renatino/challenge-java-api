package com.fiap.challenge_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MotoDTO {

    private Long idMoto;
    private String placa;
    private String modelo;
    private String status;
    private LocalDate dataCadastro;
}
