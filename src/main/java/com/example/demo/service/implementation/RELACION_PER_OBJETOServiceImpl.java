package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_PER_OBJETO;
import com.example.demo.repo.RELACION_PER_OBJETORepo;
import com.example.demo.service.RELACION_PER_OBJETOService;
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
public class RELACION_PER_OBJETOServiceImpl implements RELACION_PER_OBJETOService {

    private final RELACION_PER_OBJETORepo relacion_per_objetoRepo;
    @Override
    public RELACION_PER_OBJETO create(RELACION_PER_OBJETO relacion_per_objeto) {
        log.info("Saving new relacion_per_objeto:{}",relacion_per_objeto.getId());
        return relacion_per_objetoRepo.save(relacion_per_objeto);
    }

    @Override
    public Collection<RELACION_PER_OBJETO> list(int limit) {
        log.info("Fetching all relacion_per_objeto");
        return relacion_per_objetoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_PER_OBJETO get(Long id) {
        log.info("Fetching relacion_per_objeto by id: {}",id);
        return relacion_per_objetoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting relacion_per_objeto by ID:{}", id);
        relacion_per_objetoRepo.deleteById(id);
        return TRUE;
    }
}