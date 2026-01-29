package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.DirectorTecnicoDTO;
import com.infoplayer.jugadores.service.DirectorTecnicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/directores-tecnicos")
@RequiredArgsConstructor
public class DirectorTecnicoController {

    private final DirectorTecnicoService service;

    // 📄 Info del DT
    // GET /api/directores-tecnicos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<DirectorTecnicoDTO> obtenerDirectorTecnico(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(
                service.obtenerDirectorTecnico(id)
        );
    }
}
