package com.example.demo.service.implementation;

import com.example.demo.model.CARPETA_CLASIFICACION;
import com.example.demo.repo.CARPETA_CLASIFICACIONRepo;
import com.example.demo.service.CARPETA_CLASIFICACIONService;
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
public class CARPETA_CLASIFICACIONServiceImpl implements CARPETA_CLASIFICACIONService {

    private final CARPETA_CLASIFICACIONRepo carpeta_clasificacionRepo;
    @Override
    public CARPETA_CLASIFICACION create(CARPETA_CLASIFICACION carpeta_clasificacion) {
        log.info("Saving new carpeta_clasificacion:{}",carpeta_clasificacion.getId());
        return carpeta_clasificacionRepo.save(carpeta_clasificacion);
    }

    @Override
    public Collection<CARPETA_CLASIFICACION> list(int limit) {
        log.info("Fetching all carpeta_clasificacion");
        return carpeta_clasificacionRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARPETA_CLASIFICACION get(Long id) {
        log.info("Fetching carpeta_clasificacion by id: {}",id);
        return carpeta_clasificacionRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting carpeta_clasificacion by ID:{}", id);
        carpeta_clasificacionRepo.deleteById(id);
        return TRUE;
    }
}
