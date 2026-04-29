package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.TipoTituloDTO;
import com.infoplayer.jugadores.service.TituloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/titulos")
@RequiredArgsConstructor
public class TituloController {

    private final TituloService tituloService;

    @GetMapping("/listarTitulos")
    public ResponseEntity<List<TipoTituloDTO>> listarTitulos(){
        return ResponseEntity.ok(tituloService.listarTitulos()); //preguntar transaccional
    }
}
