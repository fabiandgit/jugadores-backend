package com.infoplayer.jugadores.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "directores_tecnicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DirectorTecnico {

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

    @OneToMany(
            mappedBy = "directorTecnico",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DirectorTecnicoEquipo> equipos = new ArrayList<>();

    @OneToMany(mappedBy = "directorTecnico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DirectorTecnicoTitulo> titulos = new ArrayList<>();

}
