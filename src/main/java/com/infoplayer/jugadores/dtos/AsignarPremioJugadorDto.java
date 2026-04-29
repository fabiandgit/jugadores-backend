package com.infoplayer.jugadores.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AsignarPremioJugadorDto {
    @NotNull
    private Integer fechaPremio;

    @NotNull
    private long idPremio;
}
