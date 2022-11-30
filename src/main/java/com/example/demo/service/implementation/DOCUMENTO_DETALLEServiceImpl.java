package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.model.DOCUMENTO_DETALLE;
import com.example.demo.repo.DOCUMENTO_DETALLERepo;
import com.example.demo.service.DOCUMENTO_DETALLEService;
import com.example.demo.service.DOCUMENTO_DETALLEService;
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
public class DOCUMENTO_DETALLEServiceImpl implements DOCUMENTO_DETALLEService {

    private final DOCUMENTO_DETALLERepo documento_detalleRepo;
    @Override
    public DOCUMENTO_DETALLE create(DOCUMENTO_DETALLE documento_detalle) {
        log.info("Saving new person:{}",documento_detalle.getDocumento_id());
        return documento_detalleRepo.save(documento_detalle);
    }

    @Override
    public Collection<DOCUMENTO_DETALLE> list(int limit) {
        log.info("Fetching all documento_detalles");
        return documento_detalleRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_DETALLE get(Long id) {
        log.info("Fetching documento_detalle by id: {}",id);
        return documento_detalleRepo.findById(id).orElse(null);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_detalle by ID:{}", id);
        documento_detalleRepo.deleteById(id);
        return TRUE;
    }
    
    
}
