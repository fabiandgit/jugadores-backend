package com.infoplayer.jugadores.dtos;

import com.infoplayer.jugadores.enums.Posicion;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class JugadorUpdateDTO {

    private String nombre;
    private String apellido;
    private String nacionalidad;
    private Posicion posicion;
    private LocalDate fechaNacimiento;
    private BigDecimal valorMercado;
    private String fotoUrl;
}
