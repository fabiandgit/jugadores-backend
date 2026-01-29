package com.infoplayer.jugadores.mappers;

import com.infoplayer.jugadores.dtos.DirectorTecnicoDTO;
import com.infoplayer.jugadores.entities.DirectorTecnico;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {com.infoplayer.jugadores.mappers.TituloMapper.class, com.infoplayer.jugadores.mappers.EquipoMapper.class})
public interface DirectorTecnicoMapper {

    DirectorTecnicoDTO toDto(DirectorTecnico directorTecnico);
}
