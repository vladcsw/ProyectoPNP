package com.example.demo.service.implementation;

import com.example.demo.model.VEHICULO_TIPO;
import com.example.demo.repo.VEHICULO_TIPORepo;
import com.example.demo.service.VEHICULO_TIPOService;
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
public class VEHICULO_TIPOServiceImpl implements VEHICULO_TIPOService {

    private final VEHICULO_TIPORepo vehiculo_tipoRepo;
    @Override
    public VEHICULO_TIPO create(VEHICULO_TIPO vehiculo_tipo) {
        log.info("Saving new vehiculo_tipo:{}",vehiculo_tipo.getId());
        return vehiculo_tipoRepo.save(vehiculo_tipo);
    }

    @Override
    public Collection<VEHICULO_TIPO> list(int limit) {
        log.info("Fetching all vehiculo_tipo");
        return vehiculo_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public VEHICULO_TIPO get(Long id) {
        log.info("Fetching vehiculo_tipo by id: {}",id);
        return vehiculo_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting vehiculo_tipo by ID:{}", id);
        vehiculo_tipoRepo.deleteById(id);
        return TRUE;
    }
}
