package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.EquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.dtos.LigaDTO;
import com.infoplayer.jugadores.service.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
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

    @GetMapping("/ligas")
    public ResponseEntity<List<LigaDTO>> listarLIgas() {
        return ResponseEntity.ok(equipoService.listarLiga());
    }

    @GetMapping("/liga")
    @Operation(summary = "Filtrar equipos por liga")
    public ResponseEntity<List<EquipoDTO>> filtrarLiga(@RequestParam String liga) {
        return ResponseEntity.ok(
                equipoService.filtrarLiga(liga)
        );
    }
}
