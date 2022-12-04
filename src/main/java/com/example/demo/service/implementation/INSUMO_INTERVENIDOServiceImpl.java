package com.example.demo.service.implementation;

import com.example.demo.model.INSUMO_INTERVENIDO;
import com.example.demo.repo.INSUMO_INTERVENIDORepo;
import com.example.demo.service.INSUMO_INTERVENIDOService;
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
public class INSUMO_INTERVENIDOServiceImpl implements INSUMO_INTERVENIDOService {

    private final INSUMO_INTERVENIDORepo insumo_intervenidoRepo;
    @Override
    public INSUMO_INTERVENIDO create(INSUMO_INTERVENIDO insumo_intervenido) {
        log.info("Saving new insumo_intervenido:{}",insumo_intervenido.getId());
        return insumo_intervenidoRepo.save(insumo_intervenido);
    }

    @Override
    public Collection<INSUMO_INTERVENIDO> list(int limit) {
        log.info("Fetching all insumo_intervenido");
        return insumo_intervenidoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INSUMO_INTERVENIDO get(Long id) {
        log.info("Fetching insumo_intervenido by id: {}",id);
        return insumo_intervenidoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting insumo_intervenido by ID:{}", id);
        insumo_intervenidoRepo.deleteById(id);
        return TRUE;
    }
}
