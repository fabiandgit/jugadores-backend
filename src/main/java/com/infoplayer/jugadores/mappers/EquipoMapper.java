package com.infoplayer.jugadores.mappers;

import com.infoplayer.jugadores.dtos.EquipoDTO;
import com.infoplayer.jugadores.entities.Equipo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TituloMapper.class})
public interface EquipoMapper {

    @Mapping(source = "liga", target = "liga")
    EquipoDTO toDTO(Equipo equipo);
}
