package com.example.demo.service.implementation;

import com.example.demo.model.PERSONA_DOMICILIO;
import com.example.demo.model.PERSONA_DOMICILIO;
import com.example.demo.repo.PERSONA_DOMICILIORepo;
import com.example.demo.service.PERSONA_DOMICILIOService;
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
public class PERSONA_DOMICILIOServiceImpl implements PERSONA_DOMICILIOService {
    private final PERSONA_DOMICILIORepo persona_domicilioRepo;
    @Override
    public PERSONA_DOMICILIO create(PERSONA_DOMICILIO persona_domicilio) {
        return persona_domicilioRepo.save(persona_domicilio);
    }

    @Override
    public Collection<PERSONA_DOMICILIO> list(int limit) {
        return persona_domicilioRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PERSONA_DOMICILIO get(Long id) {
        return persona_domicilioRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        persona_domicilioRepo.deleteById(id);
        return TRUE;
    }
}
