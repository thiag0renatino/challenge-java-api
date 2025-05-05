package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.PosicaoDTO;
import com.fiap.challenge_api.model.Posicao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PosicaoMapper {

    PosicaoDTO toDTO(Posicao entity);
    Posicao toEntity(PosicaoDTO dto);

}
