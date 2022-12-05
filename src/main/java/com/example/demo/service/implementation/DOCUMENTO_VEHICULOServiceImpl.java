package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_VEHICULO;
import com.example.demo.repo.DOCUMENTO_VEHICULORepo;
import com.example.demo.service.DOCUMENTO_VEHICULOService;
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
public class DOCUMENTO_VEHICULOServiceImpl implements DOCUMENTO_VEHICULOService {

    private final DOCUMENTO_VEHICULORepo documento_vehiculoRepo;
    @Override
    public DOCUMENTO_VEHICULO create(DOCUMENTO_VEHICULO documento_vehiculo) {
        log.info("Saving new documento_vehiculo:{}",documento_vehiculo.getId());
        return documento_vehiculoRepo.save(documento_vehiculo);
    }

    @Override
    public Collection<DOCUMENTO_VEHICULO> list(int limit) {
        log.info("Fetching all documento_vehiculo");
        return documento_vehiculoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_VEHICULO get(Long id) {
        log.info("Fetching documento_vehiculo by id: {}",id);
        return documento_vehiculoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_vehiculo by ID:{}", id);
        documento_vehiculoRepo.deleteById(id);
        return TRUE;
    }
    public Collection<DOCUMENTO_VEHICULO> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_vehiculoRepo.ByDocumentoId(id);
    }
}
