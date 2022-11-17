package com.example.demo.service.implementation;

import com.example.demo.model.GRADO_PNP;
import com.example.demo.repo.GRADO_PNPRepo;
import com.example.demo.service.GRADO_PNPService;
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
public class GRADO_PNPServiceImpl implements GRADO_PNPService {

    private final GRADO_PNPRepo grado_pnpRepo;
    @Override
    public GRADO_PNP create(GRADO_PNP grado_pnp) {
        log.info("Saving new grado_pnp:{}",grado_pnp.getId());
        return grado_pnpRepo.save(grado_pnp);
    }

    @Override
    public Collection<GRADO_PNP> list(int limit) {
        log.info("Fetching all grado_pnp");
        return grado_pnpRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public GRADO_PNP get(Long id) {
        log.info("Fetching grado_pnp by id: {}",id);
        return grado_pnpRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting grado_pnp by ID:{}", id);
        grado_pnpRepo.deleteById(id);
        return TRUE;
    }
}