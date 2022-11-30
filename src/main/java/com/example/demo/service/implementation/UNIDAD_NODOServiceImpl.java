package com.example.demo.service.implementation;

import com.example.demo.model.UNIDAD_NODO;
import com.example.demo.repo.UNIDAD_NODORepo;
import com.example.demo.service.UNIDAD_NODOService;
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
public class UNIDAD_NODOServiceImpl implements UNIDAD_NODOService {

    private final UNIDAD_NODORepo unidad_nodoRepo;
    @Override
    public UNIDAD_NODO create(UNIDAD_NODO unidad_nodo) {
        log.info("Saving new unidad_nodo:{}",unidad_nodo.getId());
        return unidad_nodoRepo.save(unidad_nodo);
    }

    @Override
    public Collection<UNIDAD_NODO> list(int limit) {
        log.info("Fetching all unidad_nodo");
        return unidad_nodoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public UNIDAD_NODO get(Long id) {
        log.info("Fetching unidad_nodo by id: {}",id);
        return unidad_nodoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting unidad_nodo by ID:{}", id);
        unidad_nodoRepo.deleteById(id);
        return TRUE;
    }
}
