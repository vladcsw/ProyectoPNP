package com.example.demo.service.implementation;

import com.example.demo.model.CARPETA_TIPO;
import com.example.demo.model.DOCUMENTO_INMUEBLE;
import com.example.demo.repo.DOCUMENTO_INMUEBLERepo;
import com.example.demo.service.DOCUMENTO_INMUEBLEService;
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
public class DOCUMENTO_INMUEBLEServiceImpl implements DOCUMENTO_INMUEBLEService {

    private final DOCUMENTO_INMUEBLERepo documento_inmuebleRepo;
    @Override
    public DOCUMENTO_INMUEBLE create(DOCUMENTO_INMUEBLE documento_inmueble) {
        log.info("Saving new documento_inmueble:{}",documento_inmueble.getId());
        return documento_inmuebleRepo.save(documento_inmueble);
    }

    @Override
    public Collection<DOCUMENTO_INMUEBLE> list(int limit) {
        log.info("Fetching all documento_inmueble");
        return documento_inmuebleRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_INMUEBLE get(Long id) {
        log.info("Fetching documento_inmueble by id: {}",id);
        return documento_inmuebleRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_inmueble by ID:{}", id);
        documento_inmuebleRepo.deleteById(id);
        return TRUE;
    }

    public Collection<DOCUMENTO_INMUEBLE> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_inmuebleRepo.ByDocumentoId(id);
    }

}
