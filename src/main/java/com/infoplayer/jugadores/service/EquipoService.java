package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.EquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;

import java.util.List;

public interface EquipoService {

    EquipoDTO obtenerEquipoPorNombre(String nombre);
    List<JugadorDTO> obtenerJugadoresActuales(Long equipoId);
}
