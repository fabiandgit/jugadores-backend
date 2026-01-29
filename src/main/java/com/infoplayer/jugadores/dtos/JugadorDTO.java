package com.infoplayer.jugadores.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDTO {

    private Long id;
    private String nombreCompleto;
    private String nacionalidad;
    private String posicion;
    private Integer edad;
    private BigDecimal valorMercado;
    private String fotoUrl;

    private EquipoActualDTO equipoActual;
    private List<TrayectoriaDTO> trayectoria;
    private List<TituloDTO> titulos;
    private List<PremioDTO> premios;
}
