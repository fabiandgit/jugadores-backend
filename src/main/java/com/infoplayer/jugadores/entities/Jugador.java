package com.infoplayer.jugadores.entities;

import com.infoplayer.jugadores.enums.Posicion;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;

@Entity
@Table(name = "jugadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private String nacionalidad;

    @Enumerated(EnumType.STRING)
    private Posicion posicion;

    @Column(name = "valor_mercado", precision = 15, scale = 2)
    private BigDecimal valorMercado;

    @Column(name = "foto_url")
    private String fotoUrl;

    // Relaciones
    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorEquipo> equipos = new ArrayList<>();

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorTitulo> titulos = new ArrayList<>();

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorPremio> premios = new ArrayList<>();

}
