package com.example.demo.service.implementation;

import com.example.demo.model.DOMICILIO;
import com.example.demo.model.EMPRESA_DOMICILIO;
import com.example.demo.repo.EMPRESA_DOMICILIORepo;
import com.example.demo.service.EMPRESA_DOMICILIOService;
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
public class EMPRESA_DOMICILIOServiceImpl implements EMPRESA_DOMICILIOService {
    private final EMPRESA_DOMICILIORepo empresa_domicilioRepo;
    @Override
    public EMPRESA_DOMICILIO create(EMPRESA_DOMICILIO empresa_domicilio) {
        return empresa_domicilioRepo.save(empresa_domicilio);
    }

    @Override
    public Collection<EMPRESA_DOMICILIO> list(int limit) {
        return empresa_domicilioRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EMPRESA_DOMICILIO get(Long id) {
        return empresa_domicilioRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        empresa_domicilioRepo.deleteById(id);
        return TRUE;
    }
}
