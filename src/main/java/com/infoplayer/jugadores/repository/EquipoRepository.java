package com.infoplayer.jugadores.repository;

import com.infoplayer.jugadores.entities.DirectorTecnico;
import com.infoplayer.jugadores.entities.Equipo;
import com.infoplayer.jugadores.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    Optional<Equipo> findByNombreIgnoreCase(String nombre);

    // Jugadores actuales del equipo
    @Query("""
        SELECT je.jugador
        FROM JugadorEquipo je
        WHERE je.equipo.id = :equipoId
          AND je.fechaFin IS NULL
    """)
    List<Jugador> findJugadoresActuales(@Param("equipoId") Long equipoId);

    // DT actual
    @Query("""
        SELECT dte.directorTecnico
        FROM DirectorTecnicoEquipo dte
        WHERE dte.equipo.id = :equipoId
          AND dte.fechaFin IS NULL
    """)
    Optional<DirectorTecnico> findDirectorTecnicoActual(@Param("equipoId") Long equipoId);
}
