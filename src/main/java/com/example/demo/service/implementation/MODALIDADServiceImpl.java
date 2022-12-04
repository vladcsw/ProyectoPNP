package com.example.demo.service.implementation;

import com.example.demo.model.MODALIDAD;
import com.example.demo.repo.MODALIDADRepo;
import com.example.demo.service.MODALIDADService;
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
public class MODALIDADServiceImpl implements MODALIDADService {

    private final MODALIDADRepo modalidadRepo;
    @Override
    public MODALIDAD create(MODALIDAD modalidad) {
        log.info("Saving new modalidad:{}",modalidad.getId());
        return modalidadRepo.save(modalidad);
    }

    @Override
    public Collection<MODALIDAD> list(int limit) {
        log.info("Fetching all modalidad");
        return modalidadRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public MODALIDAD get(Long id) {
        log.info("Fetching modalidad by id: {}",id);
        return modalidadRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting modalidad by ID:{}", id);
        modalidadRepo.deleteById(id);
        return TRUE;
    }
}
