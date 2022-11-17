package com.example.demo.service.implementation;

import com.example.demo.model.CARACTERISTICA_CLASE;
import com.example.demo.repo.CARACTERISTICA_CLASERepo;
import com.example.demo.service.CARACTERISTICA_CLASEService;
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
public class CARACTERISTICA_CLASEServiceImpl implements CARACTERISTICA_CLASEService {

    private final CARACTERISTICA_CLASERepo caracteristica_claseRepo;
    @Override
    public CARACTERISTICA_CLASE create(CARACTERISTICA_CLASE caracteristica_clase) {
        log.info("Saving new caracteristica_clase:{}",caracteristica_clase.getId());
        return caracteristica_claseRepo.save(caracteristica_clase);
    }

    @Override
    public Collection<CARACTERISTICA_CLASE> list(int limit) {
        log.info("Fetching all caracteristica_clase");
        return caracteristica_claseRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARACTERISTICA_CLASE get(Long id) {
        log.info("Fetching caracteristica_clase by id: {}",id);
        return caracteristica_claseRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting caracteristica_clase by ID:{}", id);
        caracteristica_claseRepo.deleteById(id);
        return TRUE;
    }
}