package com.infoplayer.jugadores.mappers;

import com.infoplayer.jugadores.dtos.PremioDTO;
import com.infoplayer.jugadores.dtos.TipoPremioDTO;
import com.infoplayer.jugadores.dtos.TipoTituloDTO;
import com.infoplayer.jugadores.entities.Premio;
import com.infoplayer.jugadores.entities.Titulo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PremioMapper {

    TipoPremioDTO toDTOSimple(Premio premio);

    default PremioDTO toDTO(Premio premio, Integer anio) {
        return PremioDTO.builder()
                .nombre(premio.getNombre())
                .tipo(premio.getTipoPremio().name())
                .anio(anio)
                .build();
    }
}
