package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.MarcadorArucoMovelDTO;
import com.fiap.challenge_api.model.MarcadorArucoMovel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcadorArucoMovelMapper {

    @Mapping(source = "moto.idMoto", target = "idMoto")
    MarcadorArucoMovelDTO toDTO(MarcadorArucoMovel entity);

    @Mapping(target = "moto.idMoto", source = "idMoto")
    MarcadorArucoMovel toEntity(MarcadorArucoMovelDTO dto);

}
