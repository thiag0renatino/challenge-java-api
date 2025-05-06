package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarcadorArucoMovel {

    @Id
    @Column(name = "id_marcador_movel")
    private Long idMarcadorArucoMovel;

    private String codigoAruco;

    @NotNull
    private LocalDate dataInstalacao;

    @ManyToOne
    @JoinColumn(name = "moto_id_moto")
    private Moto moto;
}
