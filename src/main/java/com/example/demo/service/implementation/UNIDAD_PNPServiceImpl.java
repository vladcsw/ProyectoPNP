package com.example.demo.service.implementation;

import com.example.demo.model.UNIDAD_PNP;
import com.example.demo.repo.UNIDAD_PNPRepo;
import com.example.demo.service.UNIDAD_PNPService;
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
public class UNIDAD_PNPServiceImpl implements UNIDAD_PNPService {

    private final UNIDAD_PNPRepo unidad_pnpRepo;
    @Override
    public UNIDAD_PNP create(UNIDAD_PNP unidad_pnp) {
        log.info("Saving new unidad_pnp:{}",unidad_pnp.getId());
        return unidad_pnpRepo.save(unidad_pnp);
    }

    @Override
    public Collection<UNIDAD_PNP> list(int limit) {
        log.info("Fetching all unidad_pnp");
        return unidad_pnpRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public UNIDAD_PNP get(Long id) {
        log.info("Fetching unidad_pnp by id: {}",id);
        return unidad_pnpRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting unidad_pnp by ID:{}", id);
        unidad_pnpRepo.deleteById(id);
        return TRUE;
    }
}
