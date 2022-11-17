package com.example.demo.service.implementation;

import com.example.demo.model.EQUIPO;
import com.example.demo.repo.EQUIPORepo;
import com.example.demo.service.EQUIPOService;
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
public class EQUIPOServiceImpl implements EQUIPOService {

    private final EQUIPORepo equipoRepo;
    @Override
    public EQUIPO create(EQUIPO equipo) {
        log.info("Saving new equipo:{}",equipo.getId());
        return equipoRepo.save(equipo);
    }

    @Override
    public Collection<EQUIPO> list(int limit) {
        log.info("Fetching all equipo");
        return equipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EQUIPO get(Long id) {
        log.info("Fetching equipo by id: {}",id);
        return equipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting equipo by ID:{}", id);
        equipoRepo.deleteById(id);
        return TRUE;
    }
}