package com.infoplayer.jugadores.mappers;

import com.infoplayer.jugadores.dtos.PremioDTO;
import com.infoplayer.jugadores.entities.Premio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PremioMapper {

    default PremioDTO toDTO(Premio premio, Integer anio) {
        return PremioDTO.builder()
                .nombre(premio.getNombre())
                .tipo(premio.getTipoPremio().name())
                .anio(anio)
                .build();
    }
}
