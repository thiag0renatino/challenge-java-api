package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.MarcadorFixoDTO;
import com.fiap.challenge_api.model.MarcadorFixo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcadorFixoMapper {

    MarcadorFixoDTO toDTO(MarcadorFixo entity);
    MarcadorFixo toEntity(MarcadorFixoDTO dto);

}
