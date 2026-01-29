package com.infoplayer.jugadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrayectoriaDTO {

    private Long equipoId;
    private String equipoNombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
}
