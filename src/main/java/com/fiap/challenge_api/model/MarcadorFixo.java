package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarcadorFixo {

    @Id
    private Long idMarcadorFixo;

    private String codigoAruco;

    @NotBlank
    private Float xPos;

    @NotBlank
    private Float yPos;

    @ManyToOne
    @JoinColumn(name = "patio_id_patio")
    private Patio patio;

    @OneToMany(mappedBy = "marcadorFixo")
    private List<MedicaoPosicao> medicoes;
}
