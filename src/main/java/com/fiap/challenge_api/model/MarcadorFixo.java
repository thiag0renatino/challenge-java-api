package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "marcador_fixo")
public class MarcadorFixo {

    @Id
    @Column(name = "id_marcador_aruco_fixo")
    private Long idMarcadorFixo;

    private String codigoAruco;

    @NotNull
    private Float xPos;

    @NotNull
    private Float yPos;

    @ManyToOne
    @JoinColumn(name = "patio_id_patio")
    private Patio patio;

    @OneToMany(mappedBy = "marcadorFixo")
    private List<MedicaoPosicao> medicoes;
}
