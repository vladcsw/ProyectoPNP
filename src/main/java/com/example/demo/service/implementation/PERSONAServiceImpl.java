package com.example.demo.service.implementation;

import com.example.demo.model.PERSONA;
import com.example.demo.model.PERSONAL_PNP;
import com.example.demo.repo.PERSONAL_PNPRepo;
import com.example.demo.repo.PERSONARepo;
import com.example.demo.service.PERSONAService;
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
public class PERSONAServiceImpl implements PERSONAService {
    private final PERSONARepo personalRepo;
    @Override
    public PERSONA create(PERSONA persona) {
        return personalRepo.save(persona);
    }

    @Override
    public Collection<PERSONA> list(int limit) {
        return personalRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public PERSONA get(Long id) {
        return personalRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        personalRepo.deleteById(id);
        return TRUE;
    }
}
