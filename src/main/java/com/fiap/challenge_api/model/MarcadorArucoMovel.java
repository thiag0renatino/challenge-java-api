package com.fiap.challenge_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
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
    private Long id;

    private String codigoAruco;

    @NotBlank
    private LocalDate dataInstalacao;

    @ManyToOne
    @JoinColumn(name = "moto_id_moto")
    private Moto moto;
}
