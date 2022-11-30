package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_PERSONA;
import com.example.demo.model.DOCUMENTO_PERSONA;
import com.example.demo.repo.DOCUMENTO_PERSONARepo;
import com.example.demo.service.DOCUMENTO_PERSONAService;
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
public class DOCUMENTO_PERSONAServiceImpl implements DOCUMENTO_PERSONAService {
    private final DOCUMENTO_PERSONARepo documento_personaRepo;
    @Override
    public DOCUMENTO_PERSONA create(DOCUMENTO_PERSONA documento_persona) {
        return documento_personaRepo.save(documento_persona);
    }

    @Override
    public Collection<DOCUMENTO_PERSONA> list(int limit) {
        return documento_personaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_PERSONA get(Long id) {
        return documento_personaRepo.findById(id).orElse(null);
    }

    @Override
    public Boolean delete(Long id) {
        documento_personaRepo.deleteById(id);
        return TRUE;
    }
}
