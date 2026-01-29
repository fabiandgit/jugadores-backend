package com.infoplayer.jugadores.mappers;


import com.infoplayer.jugadores.dtos.*;
import com.infoplayer.jugadores.entities.Jugador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipoMapper.class, TituloMapper.class, PremioMapper.class})
public interface JugadorMapper {

    @Mapping(
            target = "nombreCompleto",
            expression = "java(jugador.getNombre() + \" \" + jugador.getApellido())"
    )
    @Mapping(
            target = "edad",
            expression = "java(calcularEdad(jugador.getFechaNacimiento()))"
    )
    @Mapping(
            target = "equipoActual",
            expression = "java(mapEquipoActual(jugador))"
    )
    @Mapping(
            target = "trayectoria",
            expression = "java(mapTrayectoria(jugador))"
    )
    @Mapping(
            target = "titulos",
            expression = "java(mapTitulos(jugador))"
    )
    @Mapping(
            target = "premios",
            expression = "java(mapPremios(jugador))"
    )
    JugadorDTO toDTO(Jugador jugador);

    // ==========================
    // MÉTODOS AUXILIARES
    // ==========================

    default Integer calcularEdad(LocalDate fechaNacimiento) {
        return fechaNacimiento == null
                ? null
                : Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    default EquipoActualDTO mapEquipoActual(Jugador jugador) {
        return jugador.getEquipos().stream()
                .filter(e -> e.getFechaFin() == null)
                .findFirst()
                .map(e -> EquipoActualDTO.builder()
                        .id(e.getEquipo().getId())
                        .nombre(e.getEquipo().getNombre())
                        .liga(e.getEquipo().getLiga().name())
                        .build())
                .orElse(null);
    }

    default List<TrayectoriaDTO> mapTrayectoria(Jugador jugador) {
        return jugador.getEquipos().stream()
                .map(e -> TrayectoriaDTO.builder()
                        .equipoId(e.getEquipo().getId())
                        .equipoNombre(e.getEquipo().getNombre())
                        .fechaInicio(e.getFechaInicio())
                        .fechaFin(e.getFechaFin())
                        .build())
                .toList();
    }

    default List<TituloDTO> mapTitulos(Jugador jugador) {
        return jugador.getTitulos().stream()
                .map(jt -> TituloDTO.builder()
                        .nombre(jt.getTitulo().getNombre())
                        .tipo(jt.getTitulo().getTipoTitulo().name())
                        .anio(jt.getAnio())
                        .build())
                .toList();
    }

    default List<PremioDTO> mapPremios(Jugador jugador) {
        return jugador.getPremios().stream()
                .map(jp -> PremioDTO.builder()
                        .nombre(jp.getPremio().getNombre())
                        .tipo(jp.getPremio().getTipoPremio().name())
                        .anio(jp.getAnio())
                        .build())
                .toList();
    }

}
