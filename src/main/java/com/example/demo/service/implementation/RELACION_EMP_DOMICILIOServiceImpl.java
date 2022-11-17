package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_EMP_DOMICILIO;
import com.example.demo.model.RELACION_EMP_DOMICILIO;
import com.example.demo.repo.RELACION_EMP_DOMICILIORepo;
import com.example.demo.service.RELACION_EMP_DOMICILIOService;
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
public class RELACION_EMP_DOMICILIOServiceImpl implements RELACION_EMP_DOMICILIOService {
    private final RELACION_EMP_DOMICILIORepo relacion_emp_domicilioRepo;
    @Override
    public RELACION_EMP_DOMICILIO create(RELACION_EMP_DOMICILIO relacion_emp_domicilio) {
        return relacion_emp_domicilioRepo.save(relacion_emp_domicilio);
    }

    @Override
    public Collection<RELACION_EMP_DOMICILIO> list(int limit) {
        return relacion_emp_domicilioRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_EMP_DOMICILIO get(Long id) {
        return relacion_emp_domicilioRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        relacion_emp_domicilioRepo.deleteById(id);
        return TRUE;
    }
}
