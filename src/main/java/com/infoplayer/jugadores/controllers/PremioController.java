package com.infoplayer.jugadores.controllers;

import com.infoplayer.jugadores.dtos.TipoPremioDTO;
import com.infoplayer.jugadores.service.PremioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/premios")
@RequiredArgsConstructor
public class PremioController {

    private final PremioService premioService;

     @GetMapping("/listarPremios")
    public ResponseEntity<List<TipoPremioDTO>> listarPremios(){
        return ResponseEntity.ok(premioService.listarPremios());
    }
}
