package com.infoplayer.jugadores.mappers;

import com.infoplayer.jugadores.dtos.TipoTituloDTO;
import com.infoplayer.jugadores.dtos.TituloDTO;
import com.infoplayer.jugadores.entities.Titulo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TituloMapper {

     TipoTituloDTO toDTOSimple(Titulo titulo);

   /* default TituloDTO toDTO(Titulo titulo, Integer anio) {
        return TituloDTO.builder()
                .nombre(titulo.getNombre())
                .tipo(titulo.getTipoTitulo().name())
                .anio(anio)
                .build();
    }*/


    Titulo toEntity(TituloDTO dto);
}
