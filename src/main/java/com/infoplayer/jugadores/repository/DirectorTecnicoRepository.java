package com.infoplayer.jugadores.repository;

import com.infoplayer.jugadores.entities.DirectorTecnico;
import com.infoplayer.jugadores.entities.DirectorTecnicoEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorTecnicoRepository extends JpaRepository<DirectorTecnico,Long> {

    List<DirectorTecnico> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(
            String nombre,
            String apellido
    );

    // Historial de equipos dirigidos
    @Query("""
        SELECT dte
        FROM DirectorTecnicoEquipo dte
        WHERE dte.directorTecnico.id = :dtId
        ORDER BY dte.fechaInicio DESC
    """)
    List<DirectorTecnicoEquipo> findHistorial(@Param("dtId") Long dtId);
}
