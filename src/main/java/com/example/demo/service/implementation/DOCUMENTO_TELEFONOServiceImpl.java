package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_TELEFONO;
import com.example.demo.repo.DOCUMENTO_TELEFONORepo;
import com.example.demo.service.DOCUMENTO_TELEFONOService;
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
public class DOCUMENTO_TELEFONOServiceImpl implements DOCUMENTO_TELEFONOService {

    private final DOCUMENTO_TELEFONORepo documento_telefonoRepo;
    @Override
    public DOCUMENTO_TELEFONO create(DOCUMENTO_TELEFONO documento_telefono) {
        log.info("Saving new documento_telefono:{}",documento_telefono.getId());
        return documento_telefonoRepo.save(documento_telefono);
    }

    @Override
    public Collection<DOCUMENTO_TELEFONO> list(int limit) {
        log.info("Fetching all documento_telefono");
        return documento_telefonoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_TELEFONO get(Long id) {
        log.info("Fetching documento_telefono by id: {}",id);
        return documento_telefonoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_telefono by ID:{}", id);
        documento_telefonoRepo.deleteById(id);
        return TRUE;
    }
    public Collection<DOCUMENTO_TELEFONO> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_telefonoRepo.ByDocumentoId(id);
    }
}
