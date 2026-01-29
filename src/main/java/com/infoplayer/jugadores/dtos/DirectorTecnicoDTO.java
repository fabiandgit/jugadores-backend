package com.infoplayer.jugadores.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorTecnicoDTO {

    private Long id;
    private String nombreCompleto;
    private String nacionalidad;
    private Integer edad;
    private List<EquipoDTO> equiposDirigidos;
}
