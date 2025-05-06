package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicaoPosicao {

    @Id
    @Column(name = "id_medicao")
    private Long idMedicaoPosicao;

    @Column(name = "distancia_m")
    private Double distanciaM;

    @ManyToOne
    @JoinColumn(name = "posicao_id_posicao")
    private Posicao posicao;

    @ManyToOne
    @JoinColumn(name = "marcador_fixo_id_marcador_aruco_fixo")
    private MarcadorFixo marcadorFixo;
}
