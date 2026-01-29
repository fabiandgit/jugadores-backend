package com.infoplayer.jugadores.entities;

import com.infoplayer.jugadores.enums.Liga;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String ciudad;

    @Enumerated(EnumType.STRING)
    private Liga liga;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorEquipo> jugadores = new ArrayList<>();

    @OneToMany(
            mappedBy = "equipo",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DirectorTecnicoEquipo> directoresTecnicos = new ArrayList<>();

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquipoTitulo> titulos = new ArrayList<>();
}
