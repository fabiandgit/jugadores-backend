package com.infoplayer.jugadores.mappers;

import com.infoplayer.jugadores.dtos.TituloDTO;
import com.infoplayer.jugadores.entities.Titulo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TituloMapper {

    default TituloDTO toDTO(Titulo titulo, Integer anio) {
        return TituloDTO.builder()
                .nombre(titulo.getNombre())
                .tipo(titulo.getTipoTitulo().name())
                .anio(anio)
                .build();
    }
}
