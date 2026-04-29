package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.EquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.dtos.LigaDTO;
import com.infoplayer.jugadores.dtos.PosicionDTO;

import java.util.List;

public interface EquipoService {

    EquipoDTO obtenerEquipoPorNombre(String nombre);
    List<JugadorDTO> obtenerJugadoresActuales(Long equipoId);
    List<LigaDTO> listarLiga();
    List<EquipoDTO> filtrarLiga(String liga);
}
