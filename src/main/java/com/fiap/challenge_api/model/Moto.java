package com.fiap.challenge_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Moto {

    @Id
    private Long idMoto;

    @Column(unique = true, length = 7)
    private String placa;

    private String modelo;

    private String status;

    @NotNull
    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "moto")
    private List<Posicao> posicoes;

    @OneToMany(mappedBy = "moto")
    private List<MarcadorArucoMovel> marcadoresMoveis;

}
