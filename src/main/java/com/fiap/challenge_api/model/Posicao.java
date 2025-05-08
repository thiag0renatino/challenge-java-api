package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Posicao {

    @Id
    @Column(name = "id_posicao")
    private Long idPosicao;

    @Column(name = "x_pos")
    private Float xPos;

    @Column(name = "y_pos")
    private Float yPos;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "moto_id_moto")
    private Moto moto;

    @ManyToOne
    @JoinColumn(name = "patio_id_patio")
    private Patio patio;

    @OneToMany(mappedBy = "posicao")
    private List<MedicaoPosicao> medicoes;
}
