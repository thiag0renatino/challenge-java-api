package com.fiap.challenge_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicaoPosicaoDTO {

    private Long idMedicaoPosicao;
    private Double distanciaM;
    private Long idPosicao;
    private Long idMarcadorFixo;
}
