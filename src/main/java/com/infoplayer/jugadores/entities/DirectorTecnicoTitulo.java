package com.infoplayer.jugadores.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dt_titulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorTecnicoTitulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dt_id", nullable = false)
    private DirectorTecnico directorTecnico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "titulo_id", nullable = false)
    private Titulo titulo;

    @Column(nullable = false)
    private Integer anio;
}
