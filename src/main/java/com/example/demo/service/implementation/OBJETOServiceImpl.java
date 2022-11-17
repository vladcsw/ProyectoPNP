package com.example.demo.service.implementation;

import com.example.demo.model.OBJETO;
import com.example.demo.repo.OBJETORepo;
import com.example.demo.service.OBJETOService;
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
public class OBJETOServiceImpl implements OBJETOService {

    private final OBJETORepo objetoRepo;
    @Override
    public OBJETO create(OBJETO objeto) {
        log.info("Saving new objeto:{}",objeto.getId());
        return objetoRepo.save(objeto);
    }

    @Override
    public Collection<OBJETO> list(int limit) {
        log.info("Fetching all objeto");
        return objetoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public OBJETO get(Long id) {
        log.info("Fetching objeto by id: {}",id);
        return objetoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting objeto by ID:{}", id);
        objetoRepo.deleteById(id);
        return TRUE;
    }
}