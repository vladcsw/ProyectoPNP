package com.example.demo.service.implementation;

import com.example.demo.model.PRIORIDAD;
import com.example.demo.repo.PRIORIDADRepo;
import com.example.demo.service.PRIORIDADService;
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
public class PRIORIDADServiceImpl implements PRIORIDADService {

    private final PRIORIDADRepo prioridadRepo;
    @Override
    public PRIORIDAD create(PRIORIDAD prioridad) {
        log.info("Saving new prioridad:{}",prioridad.getId());
        return prioridadRepo.save(prioridad);
    }

    @Override
    public Collection<PRIORIDAD> list(int limit) {
        log.info("Fetching all prioridad");
        return prioridadRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PRIORIDAD get(Long id) {
        log.info("Fetching prioridad by id: {}",id);
        return prioridadRepo.findById(id).orElse(null);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting prioridad by ID:{}", id);
        prioridadRepo.deleteById(id);
        return TRUE;
    }
}
