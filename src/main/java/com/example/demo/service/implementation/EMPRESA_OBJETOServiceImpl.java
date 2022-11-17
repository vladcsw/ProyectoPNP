package com.example.demo.service.implementation;

import com.example.demo.model.EMPRESA_OBJETO;
import com.example.demo.repo.EMPRESA_OBJETORepo;
import com.example.demo.service.EMPRESA_OBJETOService;
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
public class EMPRESA_OBJETOServiceImpl implements EMPRESA_OBJETOService {

    private final EMPRESA_OBJETORepo empresa_objetoRepo;
    @Override
    public EMPRESA_OBJETO create(EMPRESA_OBJETO empresa_objeto) {
        log.info("Saving new empresa_objeto:{}",empresa_objeto.getId());
        return empresa_objetoRepo.save(empresa_objeto);
    }

    @Override
    public Collection<EMPRESA_OBJETO> list(int limit) {
        log.info("Fetching all empresa_objeto");
        return empresa_objetoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EMPRESA_OBJETO get(Long id) {
        log.info("Fetching empresa_objeto by id: {}",id);
        return empresa_objetoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting empresa_objeto by ID:{}", id);
        empresa_objetoRepo.deleteById(id);
        return TRUE;
    }
}
