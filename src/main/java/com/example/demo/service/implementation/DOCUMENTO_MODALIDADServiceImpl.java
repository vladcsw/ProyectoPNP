package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_MODALIDAD;
import com.example.demo.repo.DOCUMENTO_MODALIDADRepo;
import com.example.demo.service.DOCUMENTO_MODALIDADService;
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
public class DOCUMENTO_MODALIDADServiceImpl implements DOCUMENTO_MODALIDADService {

    private final DOCUMENTO_MODALIDADRepo documento_modalidadRepo;
    @Override
    public DOCUMENTO_MODALIDAD create(DOCUMENTO_MODALIDAD documento_modalidad) {
        log.info("Saving new documento_modalidad:{}",documento_modalidad.getId());
        return documento_modalidadRepo.save(documento_modalidad);
    }

    @Override
    public Collection<DOCUMENTO_MODALIDAD> list(int limit) {
        log.info("Fetching all documento_modalidad");
        return documento_modalidadRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_MODALIDAD get(Long id) {
        log.info("Fetching documento_modalidad by id: {}",id);
        return documento_modalidadRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_modalidad by ID:{}", id);
        documento_modalidadRepo.deleteById(id);
        return TRUE;
    }

    public Collection<DOCUMENTO_MODALIDAD> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_modalidadRepo.ByDocumentoId(id);
    }
}
