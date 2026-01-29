package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.service.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class JugadorController {

    private final JugadorService jugadorService;

    // 📋 Listar todos
    @GetMapping
    public List<JugadorDTO> listar() {
        return jugadorService.listarJugadores();
    }

    // 🔍 Buscar
    @GetMapping("/buscar")
    public List<JugadorDTO> buscar(@RequestParam String termino) {
        return jugadorService.buscarJugadores(termino);
    }

    // 📄 Ficha completa del jugador
    // GET /api/jugadores/{id}
    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> obtenerJugador(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                jugadorService.obtenerJugadorPorId(id)
        );
    }
}
