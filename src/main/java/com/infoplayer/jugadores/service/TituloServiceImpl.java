package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.TipoTituloDTO;
import com.infoplayer.jugadores.mappers.TituloMapper;
import com.infoplayer.jugadores.repository.TituloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TituloServiceImpl implements TituloService {

    private final TituloRepository tituloRepository;
    private final TituloMapper tituloMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TipoTituloDTO> listarTitulos(){
        return tituloRepository.findAll()
                .stream()
                .map(tituloMapper::toDTOSimple)
                .toList();
    }

    @Override
    public void agregarTitulo(){

    }
}
