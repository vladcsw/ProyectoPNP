package com.example.demo.service.implementation;

import com.example.demo.model.EMPRESA_PERSONA;
import com.example.demo.model.EMPRESA_PERSONA;
import com.example.demo.repo.EMPRESA_PERSONARepo;
import com.example.demo.service.EMPRESA_PERSONAService;
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
public class EMPRESA_PERSONAServiceImpl implements EMPRESA_PERSONAService {
    private final EMPRESA_PERSONARepo empresa_personaRepo;
    @Override
    public EMPRESA_PERSONA create(EMPRESA_PERSONA empresa_persona) {
        return empresa_personaRepo.save(empresa_persona);
    }

    @Override
    public Collection<EMPRESA_PERSONA> list(int limit) {
        return empresa_personaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EMPRESA_PERSONA get(Long id) {
        return empresa_personaRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        empresa_personaRepo.deleteById(id);
        return TRUE;
    }
}
