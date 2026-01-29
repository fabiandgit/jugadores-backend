package com.infoplayer.jugadores.entities;

import com.infoplayer.jugadores.enums.TipoTitulo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "titulos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_titulo", nullable = false)
    private TipoTitulo tipoTitulo;

    @OneToMany(mappedBy = "titulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorTitulo> jugadores = new ArrayList<>();

    @OneToMany(mappedBy = "titulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquipoTitulo> equipos = new ArrayList<>();

    @OneToMany(mappedBy = "titulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DirectorTecnicoTitulo> directoresTecnicos = new ArrayList<>();

}
