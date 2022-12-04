package com.example.demo.service.implementation;

import com.example.demo.model.INSUMO_SITUACION;
import com.example.demo.repo.INSUMO_SITUACIONRepo;
import com.example.demo.service.INSUMO_SITUACIONService;
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
public class INSUMO_SITUACIONServiceImpl implements INSUMO_SITUACIONService {

    private final INSUMO_SITUACIONRepo insumo_situacionRepo;
    @Override
    public INSUMO_SITUACION create(INSUMO_SITUACION insumo_situacion) {
        log.info("Saving new insumo_situacion:{}",insumo_situacion.getId());
        return insumo_situacionRepo.save(insumo_situacion);
    }

    @Override
    public Collection<INSUMO_SITUACION> list(int limit) {
        log.info("Fetching all insumo_situacion");
        return insumo_situacionRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INSUMO_SITUACION get(Long id) {
        log.info("Fetching insumo_situacion by id: {}",id);
        return insumo_situacionRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting insumo_situacion by ID:{}", id);
        insumo_situacionRepo.deleteById(id);
        return TRUE;
    }
}
