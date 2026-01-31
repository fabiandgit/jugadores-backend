package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.EquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.service.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    // 📄 Info del equipo por nombre
    // GET /api/equipos/{nombre}
    @GetMapping("/{nombre}")
    public ResponseEntity<EquipoDTO> obtenerEquipo(@PathVariable String nombre ) {
        return ResponseEntity.ok(
                equipoService.obtenerEquipoPorNombre(nombre)
        );
    }

    // ⚽ Jugadores actuales del equipo
    // GET /api/equipos/{id}/jugadores
    @GetMapping("/{id}/jugadores")
    public ResponseEntity<List<JugadorDTO>> obtenerJugadores(@PathVariable Long id) {
        return ResponseEntity.ok(
                equipoService.obtenerJugadoresActuales(id)
        );
    }
}
