package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.*;

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
    List<PosicionDTO> listarPosiciones();
    void agregarTituloJugador(Long id, AsignarTituloJugadorDto dto);
    void agregarPremioJugador(Long id, AsignarPremioJugadorDto dto);

}
