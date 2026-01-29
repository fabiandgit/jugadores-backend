package com.infoplayer.jugadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipoActualDTO {

    private Long id;
    private String nombre;
    private String liga;
}
