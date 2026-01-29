package com.infoplayer.jugadores.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugador_premio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JugadorPremio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "premio_id", nullable = false)
    private Premio premio;

    @Column(nullable = false)
    private Integer anio;
}
