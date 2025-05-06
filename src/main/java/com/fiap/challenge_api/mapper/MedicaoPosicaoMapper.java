package com.fiap.challenge_api.mapper;

import com.fiap.challenge_api.dto.MedicaoPosicaoDTO;
import com.fiap.challenge_api.model.MedicaoPosicao;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicaoPosicaoMapper {

    @Mappings({
            @Mapping(source = "posicao.idPosicao", target = "idPosicao"),
            @Mapping(source = "marcadorFixo.idMarcadorFixo", target = "idMarcadorFixo")
    })
    MedicaoPosicaoDTO toDTO(MedicaoPosicao entity);

    @InheritInverseConfiguration
    MedicaoPosicao toEntity(MedicaoPosicaoDTO dto);

    List<MedicaoPosicaoDTO> toDtoList(List<MedicaoPosicao> entities);

}
