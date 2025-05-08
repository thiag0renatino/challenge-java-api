package com.fiap.challenge_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Patio {

    @Id
    @Column(name = "id_patio")
    private Long idPatio;

    private String nome;

    @NotBlank
    private String localizacao;

    private String descricao;

    @OneToMany(mappedBy = "patio")
    private List<MarcadorFixo> marcadoresFixos;

    @OneToMany(mappedBy = "patio")
    private List<Posicao> posicoes;
}
