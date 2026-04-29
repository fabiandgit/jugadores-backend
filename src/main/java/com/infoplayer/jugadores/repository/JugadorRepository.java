package com.infoplayer.jugadores.repository;

import com.infoplayer.jugadores.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository <Jugador, Long> {

    // 🔍 Buscar por nombre o apellido (case insensitive)
    //List<Jugador> findByActivoTrueAndNombreContainingIgnoreCaseOrActivoTrueAndApellidoContainingIgnoreCase(String nombre, String apellido );
    @Query("""
       SELECT j FROM Jugador j
       WHERE j.activo = true
       AND (
            LOWER(j.nombre) LIKE LOWER(CONCAT('%', :termino, '%'))
            OR LOWER(j.apellido) LIKE LOWER(CONCAT('%', :termino, '%'))
            OR LOWER(CONCAT(j.nombre, ' ', j.apellido)) 
               LIKE LOWER(CONCAT('%', :termino, '%'))
       )
       """)
    List<Jugador> buscarPorTermino(@Param("termino") String termino);


    List<Jugador> findByActivoTrue();

    Optional<Jugador> findByIdAndActivoTrue(Long id);

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
SELECT j
FROM Jugador j
WHERE j.id = :id
  AND j.activo = true
""")
    Optional<Jugador> findByIdWithDetails(@Param("id") Long id);

    @Modifying
    @Query("""
    UPDATE Jugador j
    SET j.activo = false
    WHERE j.id = :id
""")
    void softDelete(@Param("id") Long id);

}
