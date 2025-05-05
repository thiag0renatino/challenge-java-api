package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.MarcadorArucoMovelDTO;
import com.fiap.challenge_api.model.MarcadorArucoMovel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcadorArucoMovelMapper {

    MarcadorArucoMovelDTO toDTO(MarcadorArucoMovel entity);
    MarcadorArucoMovel toEntity(MarcadorArucoMovelDTO dto);

}
