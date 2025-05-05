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
public class MarcadorArucoMovelDTO {

    private Long idMarcadorArucoMovel;
    private String codigoAruco;
    private LocalDate dataInstalacao;
    private Long idMoto;
}
