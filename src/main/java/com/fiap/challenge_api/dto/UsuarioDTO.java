package com.fiap.challenge_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioDTO {

    private Long idUsuario;
    private String nome;
    private String email;
    private String status;
    private Long patioId;

}
