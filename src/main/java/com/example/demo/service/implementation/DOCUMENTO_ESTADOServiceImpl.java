package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_ESTADO;
import com.example.demo.repo.DOCUMENTO_ESTADORepo;
import com.example.demo.service.DOCUMENTO_ESTADOService;
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
public class DOCUMENTO_ESTADOServiceImpl implements DOCUMENTO_ESTADOService {

    private final DOCUMENTO_ESTADORepo documento_estadoRepo;
    @Override
    public DOCUMENTO_ESTADO create(DOCUMENTO_ESTADO documento_estado) {
        log.info("Saving new documento_estado:{}",documento_estado.getId());
        return documento_estadoRepo.save(documento_estado);
    }

    @Override
    public Collection<DOCUMENTO_ESTADO> list(int limit) {
        log.info("Fetching all documento_estado");
        return documento_estadoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_ESTADO get(Long id) {
        log.info("Fetching documento_estado by id: {}",id);
        return documento_estadoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_estado by ID:{}", id);
        documento_estadoRepo.deleteById(id);
        return TRUE;
    }
}