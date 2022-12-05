package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_INSUMO;
import com.example.demo.repo.DOCUMENTO_INSUMORepo;
import com.example.demo.service.DOCUMENTO_INSUMOService;
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
public class DOCUMENTO_INSUMOServiceImpl implements DOCUMENTO_INSUMOService {

    private final DOCUMENTO_INSUMORepo documento_insumoRepo;
    @Override
    public DOCUMENTO_INSUMO create(DOCUMENTO_INSUMO documento_insumo) {
        log.info("Saving new documento_insumo:{}",documento_insumo.getId());
        return documento_insumoRepo.save(documento_insumo);
    }

    @Override
    public Collection<DOCUMENTO_INSUMO> list(int limit) {
        log.info("Fetching all documento_insumo");
        return documento_insumoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_INSUMO get(Long id) {
        log.info("Fetching documento_insumo by id: {}",id);
        return documento_insumoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_insumo by ID:{}", id);
        documento_insumoRepo.deleteById(id);
        return TRUE;
    }

    public Collection<DOCUMENTO_INSUMO> byDocumento(Long id) {
        log.info("byDocumento:{}", id);
        return documento_insumoRepo.ByDocumentoId(id);
    }
}
