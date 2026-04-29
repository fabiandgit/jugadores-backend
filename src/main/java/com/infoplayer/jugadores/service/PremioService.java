package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.TipoPremioDTO;

import java.util.List;

public interface PremioService {

    List<TipoPremioDTO> listarPremios();
}
