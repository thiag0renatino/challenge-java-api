package com.fiap.challenge_api.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class MarcadorArucoMovelResponseDTO {

    private Long idMarcadorMovel;
    private String codigoAruco;
    private LocalDate dataInstalacao;
    private MotoDTO moto;

    public Long getIdMarcadorMovel() {
        return idMarcadorMovel;
    }

    public void setIdMarcadorMovel(Long idMarcadorMovel) {
        this.idMarcadorMovel = idMarcadorMovel;
    }

    public String getCodigoAruco() {
        return codigoAruco;
    }

    public void setCodigoAruco(String codigoAruco) {
        this.codigoAruco = codigoAruco;
    }

    public LocalDate getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(LocalDate dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public MotoDTO getMoto() {
        return moto;
    }

    public void setMoto(MotoDTO moto) {
        this.moto = moto;
    }
}
