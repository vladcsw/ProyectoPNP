package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_CLASIFICACION;
import com.example.demo.repo.DOCUMENTO_CLASIFICACIONRepo;
import com.example.demo.service.DOCUMENTO_CLASIFICACIONService;
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
public class DOCUMENTO_CLASIFICACIONServiceImpl implements DOCUMENTO_CLASIFICACIONService {

    private final DOCUMENTO_CLASIFICACIONRepo documento_clasificacionRepo;
    @Override
    public DOCUMENTO_CLASIFICACION create(DOCUMENTO_CLASIFICACION documento_clasificacion) {
        log.info("Saving new documento_clasificacion:{}",documento_clasificacion.getId());
        return documento_clasificacionRepo.save(documento_clasificacion);
    }

    @Override
    public Collection<DOCUMENTO_CLASIFICACION> list(int limit) {
        log.info("Fetching all documento_clasificacion");
        return documento_clasificacionRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_CLASIFICACION get(Long id) {
        log.info("Fetching documento_clasificacion by id: {}",id);
        return documento_clasificacionRepo.findById(id).orElse(null);
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_clasificacion by ID:{}", id);
        documento_clasificacionRepo.deleteById(id);
        return TRUE;
    }
}