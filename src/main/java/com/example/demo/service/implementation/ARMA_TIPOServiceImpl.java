package com.example.demo.service.implementation;

import com.example.demo.model.ARMA_TIPO;
import com.example.demo.repo.ARMA_TIPORepo;
import com.example.demo.service.ARMA_TIPOService;
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
public class ARMA_TIPOServiceImpl implements ARMA_TIPOService {

    private final ARMA_TIPORepo arma_tipoRepo;
    @Override
    public ARMA_TIPO create(ARMA_TIPO arma_tipo) {
        log.info("Saving new arma_tipo:{}",arma_tipo.getId());
        return arma_tipoRepo.save(arma_tipo);
    }

    @Override
    public Collection<ARMA_TIPO> list(int limit) {
        log.info("Fetching all arma_tipo");
        return arma_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public ARMA_TIPO get(Long id) {
        log.info("Fetching arma_tipo by id: {}",id);
        return arma_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting arma_tipo by ID:{}", id);
        arma_tipoRepo.deleteById(id);
        return TRUE;
    }
}
