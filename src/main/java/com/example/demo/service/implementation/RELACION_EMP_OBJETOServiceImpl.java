package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_EMP_OBJETO;
import com.example.demo.repo.RELACION_EMP_OBJETORepo;
import com.example.demo.service.RELACION_EMP_OBJETOService;
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
public class RELACION_EMP_OBJETOServiceImpl implements RELACION_EMP_OBJETOService {

    private final RELACION_EMP_OBJETORepo relacion_emp_objetoRepo;
    @Override
    public RELACION_EMP_OBJETO create(RELACION_EMP_OBJETO relacion_emp_objeto) {
        log.info("Saving new relacion_emp_objeto:{}",relacion_emp_objeto.getId());
        return relacion_emp_objetoRepo.save(relacion_emp_objeto);
    }

    @Override
    public Collection<RELACION_EMP_OBJETO> list(int limit) {
        log.info("Fetching all relacion_emp_objeto");
        return relacion_emp_objetoRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_EMP_OBJETO get(Long id) {
        log.info("Fetching relacion_emp_objeto by id: {}",id);
        return relacion_emp_objetoRepo.findById(id).get();
    }


    @Override
    public Boolean delete(Long id) {
        log.info("Deleting relacion_emp_objeto by ID:{}", id);
        relacion_emp_objetoRepo.deleteById(id);
        return TRUE;
    }
}