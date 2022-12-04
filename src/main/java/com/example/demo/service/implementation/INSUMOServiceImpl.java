package com.example.demo.service.implementation;

import com.example.demo.model.INSUMO;
import com.example.demo.repo.INSUMORepo;
import com.example.demo.service.INSUMOService;
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
public class INSUMOServiceImpl implements INSUMOService {

    private final INSUMORepo insumoRepo;
    @Override
    public INSUMO create(INSUMO insumo) {
        log.info("Saving new insumo:{}",insumo.getId());
        return insumoRepo.save(insumo);
    }

    @Override
    public Collection<INSUMO> list(int limit) {
        log.info("Fetching all insumo");
        return insumoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public INSUMO get(Long id) {
        log.info("Fetching insumo by id: {}",id);
        return insumoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting insumo by ID:{}", id);
        insumoRepo.deleteById(id);
        return TRUE;
    }
}
