package com.example.demo.service.implementation;

import com.example.demo.model.MODALIDAD_TIPO;
import com.example.demo.repo.MODALIDAD_TIPORepo;
import com.example.demo.service.MODALIDAD_TIPOService;
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
public class MODALIDAD_TIPOServiceImpl implements MODALIDAD_TIPOService {

    private final MODALIDAD_TIPORepo modalidad_tipoRepo;
    @Override
    public MODALIDAD_TIPO create(MODALIDAD_TIPO modalidad_tipo) {
        log.info("Saving new modalidad_tipo:{}",modalidad_tipo.getId());
        return modalidad_tipoRepo.save(modalidad_tipo);
    }

    @Override
    public Collection<MODALIDAD_TIPO> list(int limit) {
        log.info("Fetching all modalidad_tipo");
        return modalidad_tipoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public MODALIDAD_TIPO get(Long id) {
        log.info("Fetching modalidad_tipo by id: {}",id);
        return modalidad_tipoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting modalidad_tipo by ID:{}", id);
        modalidad_tipoRepo.deleteById(id);
        return TRUE;
    }
}
