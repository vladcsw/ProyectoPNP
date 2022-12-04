package com.example.demo.service.implementation;

import com.example.demo.model.TELEFONO;
import com.example.demo.repo.TELEFONORepo;
import com.example.demo.service.TELEFONOService;
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
public class TELEFONOServiceImpl implements TELEFONOService {

    private final TELEFONORepo telefonoRepo;
    @Override
    public TELEFONO create(TELEFONO telefono) {
        log.info("Saving new telefono:{}",telefono.getId());
        return telefonoRepo.save(telefono);
    }

    @Override
    public Collection<TELEFONO> list(int limit) {
        log.info("Fetching all telefono");
        return telefonoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public TELEFONO get(Long id) {
        log.info("Fetching telefono by id: {}",id);
        return telefonoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting telefono by ID:{}", id);
        telefonoRepo.deleteById(id);
        return TRUE;
    }
}
