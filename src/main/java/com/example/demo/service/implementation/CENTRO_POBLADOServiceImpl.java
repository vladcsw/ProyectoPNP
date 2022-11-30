package com.example.demo.service.implementation;

import com.example.demo.model.CENTRO_POBLADO;
import com.example.demo.repo.CENTRO_POBLADORepo;
import com.example.demo.service.CENTRO_POBLADOService;
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
public class CENTRO_POBLADOServiceImpl implements CENTRO_POBLADOService {

    private final CENTRO_POBLADORepo centro_pobladoRepo;
    @Override
    public CENTRO_POBLADO create(CENTRO_POBLADO centro_poblado) {
        log.info("Saving new centro_poblado:{}",centro_poblado.getId());
        return centro_pobladoRepo.save(centro_poblado);
    }

    @Override
    public Collection<CENTRO_POBLADO> list(int limit) {
        log.info("Fetching all centro_poblado");
        return centro_pobladoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public CENTRO_POBLADO get(Long id) {
        log.info("Fetching centro_poblado by id: {}",id);
        return centro_pobladoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting centro_poblado by ID:{}", id);
        centro_pobladoRepo.deleteById(id);
        return TRUE;
    }
}
