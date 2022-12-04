package com.example.demo.service.implementation;

import com.example.demo.model.INSUMO_CALIFICACION;
import com.example.demo.repo.INSUMO_CALIFICACIONRepo;
import com.example.demo.service.INSUMO_CALIFICACIONService;
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
public class INSUMO_CALIFICACIONServiceImpl implements INSUMO_CALIFICACIONService {

    private final INSUMO_CALIFICACIONRepo insumo_calificacionRepo;
    @Override
    public INSUMO_CALIFICACION create(INSUMO_CALIFICACION insumo_calificacion) {
        log.info("Saving new insumo_calificacion:{}",insumo_calificacion.getId());
        return insumo_calificacionRepo.save(insumo_calificacion);
    }

    @Override
    public Collection<INSUMO_CALIFICACION> list(int limit) {
        log.info("Fetching all insumo_calificacion");
        return insumo_calificacionRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INSUMO_CALIFICACION get(Long id) {
        log.info("Fetching insumo_calificacion by id: {}",id);
        return insumo_calificacionRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting insumo_calificacion by ID:{}", id);
        insumo_calificacionRepo.deleteById(id);
        return TRUE;
    }
}
