package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO_CLASE;
import com.example.demo.repo.OBJETO_CLASERepo;
import com.example.demo.service.OBJETO_CLASEService;
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
public class OBJETO_CLASEServiceImpl implements OBJETO_CLASEService {

    private final OBJETO_CLASERepo objeto_claseRepo;
    @Override
    public OBJETO_CLASE create(OBJETO_CLASE objeto_clase) {
        log.info("Saving new objeto_clase:{}",objeto_clase.getId());
        return objeto_claseRepo.save(objeto_clase);
    }

    @Override
    public Collection<OBJETO_CLASE> list(int limit) {
        log.info("Fetching all objeto_clase");
        return objeto_claseRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO_CLASE get(Long id) {
        log.info("Fetching objeto_clase by id: {}",id);
        return objeto_claseRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto_clase by ID:{}", id);
        objeto_claseRepo.deleteById(id);
        return TRUE;
    }
}