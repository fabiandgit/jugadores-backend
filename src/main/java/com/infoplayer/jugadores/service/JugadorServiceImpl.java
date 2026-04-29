package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.*;
import com.infoplayer.jugadores.entities.*;
import com.infoplayer.jugadores.enums.Posicion;
import com.infoplayer.jugadores.mappers.JugadorMapper;
import com.infoplayer.jugadores.repository.*;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JugadorServiceImpl implements JugadorService{

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;
    private final JugadorMapper jugadorMapper;
    private final TituloRepository tituloRepository;
    private final JugadorTituloRepository jugadorTituloRepository;
    private final PremioRepository premioRepository;
    private final JugadorPremioRepository jugadorPremioRepository;

    @Override
    @Transactional
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
        return jugadorRepository.findByActivoTrue()
                .stream()
                .map(jugadorMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)//solo lectura no se usa en update delete  y save
    public List<JugadorDTO> buscarJugadores(String termino) {
        if (termino == null || termino.trim().isEmpty()) {
            return listarJugadores();
        }

        //primera opcion
       /* return jugadorRepository
                .findByActivoTrueAndNombreContainingIgnoreCaseOrActivoTrueAndApellidoContainingIgnoreCase(
                        termino,
                        termino
                )
                .stream()
                .map(jugadorMapper::toDTO)
                .toList();*/
        //segunda opcion
        return jugadorRepository.buscarPorTermino(termino)
                .stream()
                .map(jugadorMapper::toDTO)
                .toList();
    }

    @Override
    public JugadorDTO guardarJugador(JugadorCreateDTO dto) {

        Jugador jugador = jugadorMapper.toEntity(dto);
        Jugador jugadorGuardado = jugadorRepository.save(jugador);
        return jugadorMapper.toDTO(jugadorGuardado);
    }

    @Override
    @Transactional
    public JugadorDTO asignarEquipo(Long jugadorId, AsignarEquipoDTO dto) {

        Jugador jugador = jugadorRepository.findById(jugadorId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + jugadorId
                ));

        Equipo equipo = equipoRepository.findById(dto.getEquipoId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Equipo no encontrado con id: " + dto.getEquipoId()
                ));

        // 1️⃣ Crear equipo actual si existe
        jugador.getEquipos().stream()
                .filter(je -> je.getFechaFin() == null)
                .findFirst()
                .ifPresent(je -> je.setFechaFin(dto.getFechaInicio().minusDays(1)));

        // 2️⃣ Crear nueva relación
        JugadorEquipo nuevo = JugadorEquipo.builder()
                .jugador(jugador)
                .equipo(equipo)
                .fechaInicio(dto.getFechaInicio())
                .build();

        jugador.getEquipos().add(nuevo);

        // 3️⃣ Guardar
        Jugador jugadorGuardado = jugadorRepository.save(jugador);

        return jugadorMapper.toDTO(jugadorGuardado);
    }

    @Override
    @Transactional
    public JugadorDTO editarJugador(Long id, JugadorUpdateDTO dto) {

        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + id
                ));

        jugadorMapper.updateEntityFromDto(dto, jugador);

        Jugador actualizado = jugadorRepository.save(jugador);
        return jugadorMapper.toDTO(actualizado);
    }
    @Override
    public void eliminarJugador(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + id
                ));

        if (!jugador.getActivo()) {
            return; // o lanzar excepción personalizada si quieres
        }

        jugador.setActivo(false);
        jugadorRepository.save(jugador);
    }

    @Override
    @Transactional
    public JugadorDTO reactivarJugador(Long id) {

        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + id
                ));

        if (Boolean.TRUE.equals(jugador.getActivo())) {
            return jugadorMapper.toDTO(jugador); // ya estaba activo
        }

        jugador.setActivo(true);

        return jugadorMapper.toDTO(jugadorRepository.save(jugador));
    }

    @Override
    public List<PosicionDTO> listarPosiciones() {
        return Arrays.stream(Posicion.values())
                .map(p -> new PosicionDTO(
                        p.name(),
                        p.name().substring(0,1) + p.name().substring(1)
                ))
                .toList();
    }

    @Override
    @Transactional
    public void agregarTituloJugador(Long id, AsignarTituloJugadorDto dto) {

        // 1️⃣ Validar jugador (esto sí es obligatorio)
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + id
                ));

        // 2️⃣ Referencia del título SIN hacer query
        Titulo tituloRef = tituloRepository.getReferenceById(dto.getIdTitulo());

        // 3️⃣ Crear relación
        JugadorTitulo jugadorTitulo = JugadorTitulo.builder()
                .jugador(jugador)
                .titulo(tituloRef)
                .anio(dto.getFechaTitulo())
                .build();

        // 4️⃣ Guardar
        jugadorTituloRepository.save(jugadorTitulo);
    }

    @Override
    @Transactional
    public void agregarPremioJugador(Long id, AsignarPremioJugadorDto dto){

        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Jugador no encontrado con id: " + id
                ));

        Premio premioRef = premioRepository.getReferenceById(dto.getIdPremio());

        JugadorPremio jugadorPremio = JugadorPremio.builder()
                .jugador(jugador)
                .premio(premioRef)
                .anio(dto.getFechaPremio())
                .build();

        jugadorPremioRepository.save(jugadorPremio);
    }
}
