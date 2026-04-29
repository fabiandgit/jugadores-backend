package com.infoplayer.jugadores.service;

import com.infoplayer.jugadores.dtos.TipoPremioDTO;
import com.infoplayer.jugadores.mappers.PremioMapper;
import com.infoplayer.jugadores.repository.PremioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PremioServiceImpl implements PremioService {

    private final PremioRepository premioRepository;
    private final PremioMapper premioMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TipoPremioDTO> listarPremios(){

        return premioRepository.findAll()
                .stream()
                .map(premioMapper::toDTOSimple)
                .toList();
    }

}
