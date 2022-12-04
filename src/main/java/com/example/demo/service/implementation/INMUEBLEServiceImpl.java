package com.example.demo.service.implementation;

import com.example.demo.model.INMUEBLE;
import com.example.demo.repo.INMUEBLERepo;
import com.example.demo.service.INMUEBLEService;
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
public class INMUEBLEServiceImpl implements INMUEBLEService {

    private final INMUEBLERepo inmuebleRepo;
    @Override
    public INMUEBLE create(INMUEBLE inmueble) {
        log.info("Saving new inmueble:{}",inmueble.getId());
        return inmuebleRepo.save(inmueble);
    }

    @Override
    public Collection<INMUEBLE> list(int limit) {
        log.info("Fetching all inmueble");
        return inmuebleRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INMUEBLE get(Long id) {
        log.info("Fetching inmueble by id: {}",id);
        return inmuebleRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting inmueble by ID:{}", id);
        inmuebleRepo.deleteById(id);
        return TRUE;
    }
}
