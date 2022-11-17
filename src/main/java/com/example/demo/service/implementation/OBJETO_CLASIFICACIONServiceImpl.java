package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO_CLASIFICACION;
import com.example.demo.repo.OBJETO_CLASIFICACIONRepo;
import com.example.demo.service.OBJETO_CLASIFICACIONService;
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
public class OBJETO_CLASIFICACIONServiceImpl implements OBJETO_CLASIFICACIONService {

    private final OBJETO_CLASIFICACIONRepo objeto_clasificacionRepo;
    @Override
    public OBJETO_CLASIFICACION create(OBJETO_CLASIFICACION objeto_clasificacion) {
        log.info("Saving new objeto_clasificacion:{}",objeto_clasificacion.getId());
        return objeto_clasificacionRepo.save(objeto_clasificacion);
    }

    @Override
    public Collection<OBJETO_CLASIFICACION> list(int limit) {
        log.info("Fetching all objeto_clasificacion");
        return objeto_clasificacionRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO_CLASIFICACION get(Long id) {
        log.info("Fetching objeto_clasificacion by id: {}",id);
        return objeto_clasificacionRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto_clasificacion by ID:{}", id);
        objeto_clasificacionRepo.deleteById(id);
        return TRUE;
    }
}