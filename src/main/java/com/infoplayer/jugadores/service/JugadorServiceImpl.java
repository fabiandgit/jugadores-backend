package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.entities.Jugador;
import com.infoplayer.jugadores.mappers.JugadorMapper;
import com.infoplayer.jugadores.repository.JugadorRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JugadorServiceImpl implements JugadorService{

    private final JugadorRepository jugadorRepository;
    private final JugadorMapper jugadorMapper;

    @Override
    public JugadorDTO obtenerJugadorPorId(Long id) {
        Jugador jugador = jugadorRepository.findByIdWithDetails(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + id
                ));

        return jugadorMapper.toDTO(jugador);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> listarJugadores() {
        return jugadorRepository.findAll()
                .stream()
                .map(jugadorMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JugadorDTO> buscarJugadores(String termino) {
        if (termino == null || termino.trim().isEmpty()) {
            return listarJugadores();
        }

        return jugadorRepository
                .findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(
                        termino,
                        termino
                )
                .stream()
                .map(jugadorMapper::toDTO)
                .toList();
    }
}
