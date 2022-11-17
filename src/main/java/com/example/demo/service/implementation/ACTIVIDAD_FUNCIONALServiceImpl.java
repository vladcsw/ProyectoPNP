package com.example.demo.service.implementation;

import com.example.demo.model.ACTIVIDAD_FUNCIONAL;
import com.example.demo.repo.ACTIVIDAD_FUNCIONALRepo;
import com.example.demo.service.ACTIVIDAD_FUNCIONALService;
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
public class ACTIVIDAD_FUNCIONALServiceImpl implements ACTIVIDAD_FUNCIONALService {

    private final ACTIVIDAD_FUNCIONALRepo actividad_funcionalRepo;
    @Override
    public ACTIVIDAD_FUNCIONAL create(ACTIVIDAD_FUNCIONAL actividad_funcional) {
        log.info("Saving new actividad_funcional:{}",actividad_funcional.getId());
        return actividad_funcionalRepo.save(actividad_funcional);
    }

    @Override
    public Collection<ACTIVIDAD_FUNCIONAL> list(int limit) {
        log.info("Fetching all actividad_funcional");
        return actividad_funcionalRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public ACTIVIDAD_FUNCIONAL get(Long id) {
        log.info("Fetching actividad_funcional by id: {}",id);
        return actividad_funcionalRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting actividad_funcional by ID:{}", id);
        actividad_funcionalRepo.deleteById(id);
        return TRUE;
    }
}