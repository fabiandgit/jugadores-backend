package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.AsignarTituloJugadorDto;
import com.infoplayer.jugadores.dtos.TipoTituloDTO;
import com.infoplayer.jugadores.dtos.TituloDTO;

import java.util.List;

public interface TituloService {
    List<TipoTituloDTO> listarTitulos();
    void agregarTitulo();
}
