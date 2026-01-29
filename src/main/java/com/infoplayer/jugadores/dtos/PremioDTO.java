package com.infoplayer.jugadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PremioDTO {

    private String nombre;
    private String tipo;
    private Integer anio;
}
