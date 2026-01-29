package com.infoplayer.jugadores.repository;

import com.infoplayer.jugadores.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository <Jugador, Long> {

    // 🔍 Buscar por nombre o apellido (case insensitive)
    List<Jugador> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(
            String nombre,
            String apellido
    );

    // ⚽ Equipo actual del jugador
    @Query("""
        SELECT je.equipo
        FROM JugadorEquipo je
        WHERE je.jugador.id = :jugadorId
          AND je.fechaFin IS NULL
    """)
    Optional<Equipo> findEquipoActual(@Param("jugadorId") Long jugadorId);

    // 🧾 Historial de equipos
    @Query("""
        SELECT je
        FROM JugadorEquipo je
        WHERE je.jugador.id = :jugadorId
        ORDER BY je.fechaInicio DESC
    """)
    List<JugadorEquipo> findTrayectoria(@Param("jugadorId") Long jugadorId);

    // 🏆 Títulos del jugador
    @Query("""
        SELECT jt
        FROM JugadorTitulo jt
        WHERE jt.jugador.id = :jugadorId
        ORDER BY jt.anio DESC
    """)
    List<JugadorTitulo> findTitulos(@Param("jugadorId") Long jugadorId);

    // 🥇 Premios del jugador
    @Query("""
        SELECT jp
        FROM JugadorPremio jp
        WHERE jp.jugador.id = :jugadorId
        ORDER BY jp.anio DESC
    """)
    List<JugadorPremio> findPremios(@Param("jugadorId") Long jugadorId);

    // 🔥 Query PRO: jugador + todo cargado
    @Query("""
        SELECT DISTINCT j
        FROM Jugador j
        LEFT JOIN FETCH j.equipos
        LEFT JOIN FETCH j.titulos
        LEFT JOIN FETCH j.premios
        WHERE j.id = :id
    """)
    Optional<Jugador> findByIdWithDetails(@Param("id") Long id);
}
