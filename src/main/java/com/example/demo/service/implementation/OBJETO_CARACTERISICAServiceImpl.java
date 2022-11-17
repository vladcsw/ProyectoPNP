package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO_CARACTERISICA;
import com.example.demo.repo.OBJETO_CARACTERISICARepo;
import com.example.demo.service.OBJETO_CARACTERISICAService;
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
public class OBJETO_CARACTERISICAServiceImpl implements OBJETO_CARACTERISICAService {

    private final OBJETO_CARACTERISICARepo objeto_caracterisicaRepo;
    @Override
    public OBJETO_CARACTERISICA create(OBJETO_CARACTERISICA objeto_caracterisica) {
        log.info("Saving new objeto_caracterisica:{}",objeto_caracterisica.getId());
        return objeto_caracterisicaRepo.save(objeto_caracterisica);
    }

    @Override
    public Collection<OBJETO_CARACTERISICA> list(int limit) {
        log.info("Fetching all objeto_caracterisica");
        return objeto_caracterisicaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO_CARACTERISICA get(Long id) {
        log.info("Fetching objeto_caracterisica by id: {}",id);
        return objeto_caracterisicaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto_caracterisica by ID:{}", id);
        objeto_caracterisicaRepo.deleteById(id);
        return TRUE;
    }
}