package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.AsignarEquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorCreateDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.dtos.JugadorUpdateDTO;

import java.util.List;

public interface JugadorService {

    JugadorDTO obtenerJugadorPorId(Long id);
    List<JugadorDTO> buscarJugadores(String termino);
    List<JugadorDTO> listarJugadores();
    JugadorDTO guardarJugador(JugadorCreateDTO dto);
    JugadorDTO asignarEquipo(Long jugadorId, AsignarEquipoDTO dto);
    JugadorDTO editarJugador(Long id, JugadorUpdateDTO dto);
    void eliminarJugador(Long id);
    JugadorDTO reactivarJugador(Long id);
}
