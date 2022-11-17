package com.example.demo.service.implementation;

import com.example.demo.model.PERSONA_OBJETO;
import com.example.demo.repo.PERSONA_OBJETORepo;
import com.example.demo.service.PERSONA_OBJETOService;
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
public class PERSONA_OBJETOServiceImpl implements PERSONA_OBJETOService {

    private final PERSONA_OBJETORepo persona_objetoRepo;
    @Override
    public PERSONA_OBJETO create(PERSONA_OBJETO persona_objeto) {
        log.info("Saving new persona_objeto:{}",persona_objeto.getId());
        return persona_objetoRepo.save(persona_objeto);
    }

    @Override
    public Collection<PERSONA_OBJETO> list(int limit) {
        log.info("Fetching all persona_objeto");
        return persona_objetoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PERSONA_OBJETO get(Long id) {
        log.info("Fetching persona_objeto by id: {}",id);
        return persona_objetoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting persona_objeto by ID:{}", id);
        persona_objetoRepo.deleteById(id);
        return TRUE;
    }
}
