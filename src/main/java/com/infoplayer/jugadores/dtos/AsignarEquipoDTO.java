package com.infoplayer.jugadores.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AsignarEquipoDTO {

    @NotNull
    private Long equipoId;

    @NotNull
    private LocalDate fechaInicio;
}
