package com.example.demo.service.implementation;

import com.example.demo.model.EQUIPO_CARGO;
import com.example.demo.repo.EQUIPO_CARGORepo;
import com.example.demo.service.EQUIPO_CARGOService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class EQUIPO_CARGOServiceImpl implements EQUIPO_CARGOService {

    private final EQUIPO_CARGORepo equipo_cargoRepo;
    @Override
    public EQUIPO_CARGO create(EQUIPO_CARGO equipo_cargo) {
        log.info("Saving new equipo_cargo:{}",equipo_cargo.getId());
        return equipo_cargoRepo.save(equipo_cargo);
    }

    @Override
    public Collection<EQUIPO_CARGO> list(int limit) {
        log.info("Fetching all equipo_cargo");
        return equipo_cargoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EQUIPO_CARGO get(Long id) {
        log.info("Fetching equipo_cargo by id: {}",id);
        return equipo_cargoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting equipo_cargo by ID:{}", id);
        equipo_cargoRepo.deleteById(id);
        return TRUE;
    }
}