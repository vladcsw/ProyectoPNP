package com.example.demo.service.implementation;

import com.example.demo.model.MODELO;
import com.example.demo.repo.MODELORepo;
import com.example.demo.service.MODELOService;
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
public class MODELOServiceImpl implements MODELOService {

    private final MODELORepo modeloRepo;
    @Override
    public MODELO create(MODELO modelo) {
        log.info("Saving new modelo:{}",modelo.getId());
        return modeloRepo.save(modelo);
    }

    @Override
    public Collection<MODELO> list(int limit) {
        log.info("Fetching all modelo");
        return modeloRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public MODELO get(Long id) {
        log.info("Fetching modelo by id: {}",id);
        return modeloRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting modelo by ID:{}", id);
        modeloRepo.deleteById(id);
        return TRUE;
    }
}