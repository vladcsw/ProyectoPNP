package com.example.demo.service.implementation;

import com.example.demo.model.CARACTERISTICA_TIPO;
import com.example.demo.repo.CARACTERISTICA_TIPORepo;
import com.example.demo.service.CARACTERISTICA_TIPOService;
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
public class CARACTERISTICA_TIPOServiceImpl implements CARACTERISTICA_TIPOService {

    private final CARACTERISTICA_TIPORepo caracteristica_tipoRepo;
    @Override
    public CARACTERISTICA_TIPO create(CARACTERISTICA_TIPO caracteristica_tipo) {
        log.info("Saving new caracteristica_tipo:{}",caracteristica_tipo.getId());
        return caracteristica_tipoRepo.save(caracteristica_tipo);
    }

    @Override
    public Collection<CARACTERISTICA_TIPO> list(int limit) {
        log.info("Fetching all caracteristica_tipo");
        return caracteristica_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CARACTERISTICA_TIPO get(Long id) {
        log.info("Fetching caracteristica_tipo by id: {}",id);
        return caracteristica_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting caracteristica_tipo by ID:{}", id);
        caracteristica_tipoRepo.deleteById(id);
        return TRUE;
    }
}