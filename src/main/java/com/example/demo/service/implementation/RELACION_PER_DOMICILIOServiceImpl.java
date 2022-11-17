package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_PER_DOMICILIO;
import com.example.demo.model.RELACION_PER_DOMICILIO;
import com.example.demo.repo.RELACION_PER_DOMICILIORepo;
import com.example.demo.service.RELACION_PER_DOMICILIOService;
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
public class RELACION_PER_DOMICILIOServiceImpl implements RELACION_PER_DOMICILIOService {
    private final RELACION_PER_DOMICILIORepo relacion_per_domicilioRepo;
    @Override
    public RELACION_PER_DOMICILIO create(RELACION_PER_DOMICILIO relacion_per_domicilio) {
        return relacion_per_domicilioRepo.save(relacion_per_domicilio);
    }

    @Override
    public Collection<RELACION_PER_DOMICILIO> list(int limit) {
        return relacion_per_domicilioRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_PER_DOMICILIO get(Long id) {
        return relacion_per_domicilioRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        relacion_per_domicilioRepo.deleteById(id);
        return TRUE;
    }
}
