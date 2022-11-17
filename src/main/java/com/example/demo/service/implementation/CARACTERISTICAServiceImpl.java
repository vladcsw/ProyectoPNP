package com.example.demo.service.implementation;

import com.example.demo.model.CARACTERISTICA;
import com.example.demo.repo.CARACTERISTICARepo;
import com.example.demo.service.CARACTERISTICAService;
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
public class CARACTERISTICAServiceImpl implements CARACTERISTICAService {

    private final CARACTERISTICARepo caracteristicaRepo;
    @Override
    public CARACTERISTICA create(CARACTERISTICA caracteristica) {
        log.info("Saving new caracteristica:{}",caracteristica.getId());
        return caracteristicaRepo.save(caracteristica);
    }

    @Override
    public Collection<CARACTERISTICA> list(int limit) {
        log.info("Fetching all caracteristica");
        return caracteristicaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARACTERISTICA get(Long id) {
        log.info("Fetching caracteristica by id: {}",id);
        return caracteristicaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting caracteristica by ID:{}", id);
        caracteristicaRepo.deleteById(id);
        return TRUE;
    }
}
