package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.AsignarEquipoDTO;
import com.infoplayer.jugadores.dtos.JugadorCreateDTO;
import com.infoplayer.jugadores.dtos.JugadorDTO;
import com.infoplayer.jugadores.dtos.JugadorUpdateDTO;
import com.infoplayer.jugadores.service.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<JugadorDTO> obtenerJugador(@PathVariable Long id) {
        return ResponseEntity.ok(
                jugadorService.obtenerJugadorPorId(id)
        );
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo jugador")
    public ResponseEntity<JugadorDTO> crearJugador(@Valid @RequestBody JugadorCreateDTO dto) {
        JugadorDTO jugador = jugadorService.guardarJugador(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(jugador);
    }

    @PatchMapping("/{id}/equipo")
    public ResponseEntity<JugadorDTO> asignarEquipo(@PathVariable Long id, @Valid @RequestBody AsignarEquipoDTO dto) {
        return ResponseEntity.ok(jugadorService.asignarEquipo(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<JugadorDTO> editarJugador(@PathVariable Long id, @RequestBody JugadorUpdateDTO dto) {
        return ResponseEntity.ok(
                jugadorService.editarJugador(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
        return ResponseEntity.ok(true);
    }

    @PatchMapping("/{id}/reactivar")
    public ResponseEntity<JugadorDTO> reactivarJugador(@PathVariable Long id) {
        return ResponseEntity.ok(
                jugadorService.reactivarJugador(id)
        );
    }

}
