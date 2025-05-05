package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.MedicaoPosicaoDTO;
import com.fiap.challenge_api.model.MedicaoPosicao;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicaoPosicaoMapper {

    MedicaoPosicaoDTO toDTO(MedicaoPosicao entity);
    MedicaoPosicao toEntity(MedicaoPosicaoDTO dto);

}
