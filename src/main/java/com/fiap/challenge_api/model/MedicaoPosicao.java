package com.fiap.challenge_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicaoPosicao {

    @Id
    private Long idMedicaoPosicao;

    private Double distanciaM;

    @ManyToOne
    @JoinColumn(name = "posicao_id_posicao")
    private Posicao posicao;

    @ManyToOne
    @JoinColumn(name = "marcador_fixo_id")
    private MarcadorFixo marcadorFixo;
}
