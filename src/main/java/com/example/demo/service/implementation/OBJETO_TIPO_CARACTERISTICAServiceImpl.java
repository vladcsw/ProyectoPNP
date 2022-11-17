package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO_TIPO_CARACTERISTICA;
import com.example.demo.repo.OBJETO_TIPO_CARACTERISTICARepo;
import com.example.demo.service.OBJETO_TIPO_CARACTERISTICAService;
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
public class OBJETO_TIPO_CARACTERISTICAServiceImpl implements OBJETO_TIPO_CARACTERISTICAService {

    private final OBJETO_TIPO_CARACTERISTICARepo objeto_tipo_caracteristicaRepo;
    @Override
    public OBJETO_TIPO_CARACTERISTICA create(OBJETO_TIPO_CARACTERISTICA objeto_tipo_caracteristica) {
        log.info("Saving new objeto_tipo_caracteristica:{}",objeto_tipo_caracteristica.getId());
        return objeto_tipo_caracteristicaRepo.save(objeto_tipo_caracteristica);
    }

    @Override
    public Collection<OBJETO_TIPO_CARACTERISTICA> list(int limit) {
        log.info("Fetching all objeto_tipo_caracteristica");
        return objeto_tipo_caracteristicaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO_TIPO_CARACTERISTICA get(Long id) {
        log.info("Fetching objeto_tipo_caracteristica by id: {}",id);
        return objeto_tipo_caracteristicaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto_tipo_caracteristica by ID:{}", id);
        objeto_tipo_caracteristicaRepo.deleteById(id);
        return TRUE;
    }
}