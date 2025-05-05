package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.MarcadorFixoDTO;
import com.fiap.challenge_api.model.MarcadorFixo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MarcadorFixoMapper {

    @Mapping(source = "patio.idPatio", target = "idPatio")
    MarcadorFixoDTO toDTO(MarcadorFixo entity);

    @Mapping(source = "idPatio", target = "patio.idPatio")
    MarcadorFixo toEntity(MarcadorFixoDTO dto);

}
