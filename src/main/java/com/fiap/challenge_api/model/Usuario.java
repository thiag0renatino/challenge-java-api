package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    private String senha;

    private String status = "ativo";

    @ManyToOne
    @JoinColumn(name = "patio_id_patio")
    private Patio patio;
}
