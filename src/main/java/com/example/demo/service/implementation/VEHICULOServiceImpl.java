package com.example.demo.service.implementation;

import com.example.demo.model.VEHICULO;
import com.example.demo.repo.VEHICULORepo;
import com.example.demo.service.VEHICULOService;
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
public class VEHICULOServiceImpl implements VEHICULOService {

    private final VEHICULORepo vehiculoRepo;
    @Override
    public VEHICULO create(VEHICULO vehiculo) {
        log.info("Saving new vehiculo:{}",vehiculo.getId());
        return vehiculoRepo.save(vehiculo);
    }

    @Override
    public Collection<VEHICULO> list(int limit) {
        log.info("Fetching all vehiculo");
        return vehiculoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public VEHICULO get(Long id) {
        log.info("Fetching vehiculo by id: {}",id);
        return vehiculoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting vehiculo by ID:{}", id);
        vehiculoRepo.deleteById(id);
        return TRUE;
    }
}
