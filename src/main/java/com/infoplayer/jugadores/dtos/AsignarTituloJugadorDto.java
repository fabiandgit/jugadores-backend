package com.infoplayer.jugadores.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AsignarTituloJugadorDto {

    @NotNull
    private Integer fechaTitulo;

    @NotNull
    private long idTitulo;
}
