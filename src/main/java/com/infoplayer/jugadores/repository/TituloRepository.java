package com.infoplayer.jugadores.repository;

import com.infoplayer.jugadores.entities.Titulo;
import com.infoplayer.jugadores.enums.TipoTitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {

    List<Titulo> findByTipoTitulo(TipoTitulo tipoTitulo);
}
