package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO_TIPO;
import com.example.demo.repo.OBJETO_TIPORepo;
import com.example.demo.service.OBJETO_TIPOService;
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
public class OBJETO_TIPOServiceImpl implements OBJETO_TIPOService {

    private final OBJETO_TIPORepo objeto_tipoRepo;
    @Override
    public OBJETO_TIPO create(OBJETO_TIPO objeto_tipo) {
        log.info("Saving new objeto_tipo:{}",objeto_tipo.getId());
        return objeto_tipoRepo.save(objeto_tipo);
    }

    @Override
    public Collection<OBJETO_TIPO> list(int limit) {
        log.info("Fetching all objeto_tipo");
        return objeto_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO_TIPO get(Long id) {
        log.info("Fetching objeto_tipo by id: {}",id);
        return objeto_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto_tipo by ID:{}", id);
        objeto_tipoRepo.deleteById(id);
        return TRUE;
    }
}