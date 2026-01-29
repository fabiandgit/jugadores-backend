package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.DirectorTecnicoDTO;
import com.infoplayer.jugadores.entities.DirectorTecnico;
import com.infoplayer.jugadores.repository.DirectorTecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DirectorTecnicoServiceImpl implements   DirectorTecnicoService{

    private final DirectorTecnicoRepository repository;

    @Override
    public DirectorTecnicoDTO obtenerDirectorTecnico(Long id) {
        DirectorTecnico dt = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Director técnico no encontrado con id: " + id
                ));

        return DirectorTecnicoDTO.builder()
                .id(dt.getId())
                .nombreCompleto(dt.getNombre() + " " + dt.getApellido())
                .nacionalidad(dt.getNacionalidad())
                .edad(
                        dt.getFechaNacimiento() == null
                                ? null
                                : Period.between(
                                dt.getFechaNacimiento(),
                                LocalDate.now()
                        ).getYears()
                )
                .build();
    }
}
