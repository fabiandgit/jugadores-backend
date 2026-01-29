package com.infoplayer.jugadores.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipo_titulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipoTitulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titulo_id", nullable = false)
    private Titulo titulo;

    @Column(nullable = false)
    private Integer anio;
}
