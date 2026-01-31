package com.infoplayer.jugadores.dtos;

import com.infoplayer.jugadores.enums.Posicion;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorCreateDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String nacionalidad;

    @NotNull
    private Posicion posicion;

    @NotNull
    private LocalDate fechaNacimiento;

    @DecimalMin("0.0")
    private BigDecimal valorMercado;

    private String fotoUrl;
}
