package com.fiap.challenge_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MarcadorFixoDTO {

    private Long idMarcadorFixo;
    private String codigoAruco;
    private Float xPos;
    private Float yPos;
    private Long idPatio;
}
