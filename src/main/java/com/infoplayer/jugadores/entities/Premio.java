package com.infoplayer.jugadores.entities;

import com.infoplayer.jugadores.enums.TipoPremio;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "premios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_premio", nullable = false)
    private TipoPremio tipoPremio;

    @OneToMany(mappedBy = "premio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JugadorPremio> jugadores = new ArrayList<>();

}
