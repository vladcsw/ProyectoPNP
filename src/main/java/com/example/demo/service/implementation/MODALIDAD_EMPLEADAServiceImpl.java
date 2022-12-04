package com.example.demo.service.implementation;

import com.example.demo.model.MODALIDAD_EMPLEADA;
import com.example.demo.repo.MODALIDAD_EMPLEADARepo;
import com.example.demo.service.MODALIDAD_EMPLEADAService;
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
public class MODALIDAD_EMPLEADAServiceImpl implements MODALIDAD_EMPLEADAService {

    private final MODALIDAD_EMPLEADARepo modalidad_empleadaRepo;
    @Override
    public MODALIDAD_EMPLEADA create(MODALIDAD_EMPLEADA modalidad_empleada) {
        log.info("Saving new modalidad_empleada:{}",modalidad_empleada.getId());
        return modalidad_empleadaRepo.save(modalidad_empleada);
    }

    @Override
    public Collection<MODALIDAD_EMPLEADA> list(int limit) {
        log.info("Fetching all modalidad_empleada");
        return modalidad_empleadaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public MODALIDAD_EMPLEADA get(Long id) {
        log.info("Fetching modalidad_empleada by id: {}",id);
        return modalidad_empleadaRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting modalidad_empleada by ID:{}", id);
        modalidad_empleadaRepo.deleteById(id);
        return TRUE;
    }
}
