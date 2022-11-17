package com.example.demo.service.implementation;

import com.example.demo.model.PERSONAL_GRADO;
import com.example.demo.repo.PERSONAL_GRADORepo;
import com.example.demo.service.PERSONAL_GRADOService;
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
public class PERSONAL_GRADOServiceImpl implements PERSONAL_GRADOService {

    private final PERSONAL_GRADORepo personal_gradoRepo;
    @Override
    public PERSONAL_GRADO create(PERSONAL_GRADO personal_grado) {
        log.info("Saving new personal_grado:{}",personal_grado.getId());
        return personal_gradoRepo.save(personal_grado);
    }

    @Override
    public Collection<PERSONAL_GRADO> list(int limit) {
        log.info("Fetching all personal_grado");
        return personal_gradoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PERSONAL_GRADO get(Long id) {
        log.info("Fetching personal_grado by id: {}",id);
        return personal_gradoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting personal_grado by ID:{}", id);
        personal_gradoRepo.deleteById(id);
        return TRUE;
    }
}
