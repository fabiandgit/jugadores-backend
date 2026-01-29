package com.infoplayer.jugadores.repository;

import com.infoplayer.jugadores.entities.Premio;
import com.infoplayer.jugadores.enums.TipoPremio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremioRepository extends JpaRepository <Premio,Long> {

    List<Premio> findByTipoPremio(TipoPremio tipoPremio);

}
