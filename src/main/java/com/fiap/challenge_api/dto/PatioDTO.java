package com.fiap.challenge_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PatioDTO {

    private Long idPatio;
    private String nome;
    private String localizacao;
    private String  descricao;
}
