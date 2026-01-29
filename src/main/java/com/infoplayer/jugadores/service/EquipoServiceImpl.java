package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.EquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;

import com.infoplayer.jugadores.entities.Equipo;
import com.infoplayer.jugadores.mappers.EquipoMapper;
import com.infoplayer.jugadores.mappers.JugadorMapper;
import com.infoplayer.jugadores.repository.EquipoRepository;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquipoServiceImpl implements EquipoService{

    private final EquipoRepository equipoRepository;
    private final JugadorMapper jugadorMapper;
    private final EquipoMapper equipoMapper;

    @Override
    public EquipoDTO obtenerEquipoPorNombre(String nombre) {
        Equipo equipo = equipoRepository.findByNombreIgnoreCase(nombre)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Equipo no encontrado: " + nombre
                ));

        return equipoMapper.toDTO(equipo);
    }

    @Override
    public List<JugadorDTO> obtenerJugadoresActuales(Long equipoId) {
        return equipoRepository.findJugadoresActuales(equipoId)
                .stream()
                .map(jugadorMapper::toDTO)
                .toList();
    }
}
