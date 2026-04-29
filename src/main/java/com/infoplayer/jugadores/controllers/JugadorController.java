package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.*;
import com.infoplayer.jugadores.service.JugadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService jugadorService;

    // 📋 Listar
    @GetMapping
    public List<JugadorDTO> listar() {
        return jugadorService.listarJugadores();
    }

    // 🔍 Buscar
    @GetMapping("/buscar")
    public List<JugadorDTO> buscar(@RequestParam String termino) {
        return jugadorService.buscarJugadores(termino);
    }

    // 📄 Obtener por ID
    @GetMapping("/{id}/porId")
    public ResponseEntity<JugadorDTO> obtenerJugador(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.obtenerJugadorPorId(id));
    }

    // ➕ Crear
    @PostMapping
    public ResponseEntity<JugadorDTO> crearJugador(@Valid @RequestBody JugadorCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jugadorService.guardarJugador(dto));
    }

    // ✏️ Editar
    @PatchMapping("/{id}/editar")
    public ResponseEntity<JugadorDTO> editarJugador(@PathVariable Long id,
                                                    @RequestBody JugadorUpdateDTO dto) {
        return ResponseEntity.ok(jugadorService.editarJugador(id, dto));
    }

    // ❌ Eliminar (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Long id) {
        jugadorService.eliminarJugador(id);
        return ResponseEntity.noContent().build();
    }

    // ♻️ Reactivar
    @PatchMapping("/{id}/reactivar")
    public ResponseEntity<JugadorDTO> reactivarJugador(@PathVariable Long id) {
        return ResponseEntity.ok(jugadorService.reactivarJugador(id));
    }

    // ⚽ Asignar equipo
    @PatchMapping("/{id}/equipo")
    public ResponseEntity<JugadorDTO> asignarEquipo(@PathVariable Long id,
                                                    @Valid @RequestBody AsignarEquipoDTO dto) {
        return ResponseEntity.ok(jugadorService.asignarEquipo(id, dto));
    }

    // 📊 Posiciones
    @GetMapping("/posiciones")
    public ResponseEntity<List<PosicionDTO>> listarPosiciones() {
        return ResponseEntity.ok(jugadorService.listarPosiciones());
    }

    @PostMapping("/{id}/titulos")
    public ResponseEntity<Void> agregarTituloJugador(@PathVariable Long id,
                                                     @Valid @RequestBody AsignarTituloJugadorDto dto) {

        jugadorService.agregarTituloJugador(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{id}/premios")
    public ResponseEntity<Void> agregarPremioJugador(@PathVariable Long id,
                                                     @Valid @RequestBody AsignarPremioJugadorDto dto){
        jugadorService.agregarPremioJugador(id,dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
