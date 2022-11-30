package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_CARACTERISTICA;
import com.example.demo.repo.DOCUMENTO_CARACTERISTICARepo;
import com.example.demo.service.DOCUMENTO_CARACTERISTICAService;
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
public class DOCUMENTO_CARACTERISTICAServiceImpl implements DOCUMENTO_CARACTERISTICAService {

    private final DOCUMENTO_CARACTERISTICARepo documento_caracteristicaRepo;
    @Override
    public DOCUMENTO_CARACTERISTICA create(DOCUMENTO_CARACTERISTICA documento_caracteristica) {
        log.info("Saving new documento_caracteristica:{}",documento_caracteristica.getId());
        return documento_caracteristicaRepo.save(documento_caracteristica);
    }

    @Override
    public Collection<DOCUMENTO_CARACTERISTICA> list(int limit) {
        log.info("Fetching all documento_caracteristica");
        return documento_caracteristicaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_CARACTERISTICA get(Long id) {
        log.info("Fetching documento_caracteristica by id: {}",id);
        //return documento_caracteristicaRepo.findById(id).get();
        return documento_caracteristicaRepo.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting documento_caracteristica by ID:{}", id);
        documento_caracteristicaRepo.deleteById(id);
        return TRUE;
    }
}