package com.example.demo.service.implementation;

import com.example.demo.model.NACIONALIDAD;
import com.example.demo.repo.NACIONALIDADRepo;
import com.example.demo.service.NACIONALIDADService;
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
public class NACIONALIDADServiceImpl implements NACIONALIDADService {

    private final NACIONALIDADRepo nacionalidadRepo;
    @Override
    public NACIONALIDAD create(NACIONALIDAD nacionalidad) {
        log.info("Saving new nacionalidad:{}",nacionalidad.getId());
        return nacionalidadRepo.save(nacionalidad);
    }

    @Override
    public Collection<NACIONALIDAD> list(int limit) {
        log.info("Fetching all nacionalidad");
        return nacionalidadRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public NACIONALIDAD get(Long id) {
        log.info("Fetching nacionalidad by id: {}",id);
        return nacionalidadRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting nacionalidad by ID:{}", id);
        nacionalidadRepo.deleteById(id);
        return TRUE;
    }
}
