package com.example.demo.service.implementation;

import com.example.demo.model.ARMA_CALIFICACION;
import com.example.demo.repo.ARMA_CALIFICACIONRepo;
import com.example.demo.service.ARMA_CALIFICACIONService;
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
public class ARMA_CALIFICACIONServiceImpl implements ARMA_CALIFICACIONService {

    private final ARMA_CALIFICACIONRepo arma_calificacionRepo;
    @Override
    public ARMA_CALIFICACION create(ARMA_CALIFICACION arma_calificacion) {
        log.info("Saving new arma_calificacion:{}",arma_calificacion.getId());
        return arma_calificacionRepo.save(arma_calificacion);
    }

    @Override
    public Collection<ARMA_CALIFICACION> list(int limit) {
        log.info("Fetching all arma_calificacion");
        return arma_calificacionRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public ARMA_CALIFICACION get(Long id) {
        log.info("Fetching arma_calificacion by id: {}",id);
        return arma_calificacionRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting arma_calificacion by ID:{}", id);
        arma_calificacionRepo.deleteById(id);
        return TRUE;
    }
}
