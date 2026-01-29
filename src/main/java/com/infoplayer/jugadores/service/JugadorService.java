package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.JugadorDTO;

import java.util.List;

public interface JugadorService {

    JugadorDTO obtenerJugadorPorId(Long id);
    List<JugadorDTO> buscarJugadores(String termino);
    List<JugadorDTO> listarJugadores();
}
