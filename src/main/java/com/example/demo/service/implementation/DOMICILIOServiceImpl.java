package com.example.demo.service.implementation;

import com.example.demo.model.DOMICILIO;
import com.example.demo.model.DOMICILIO;
import com.example.demo.repo.DOMICILIORepo;
import com.example.demo.service.DOMICILIOService;
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
public class DOMICILIOServiceImpl implements DOMICILIOService {
    private final DOMICILIORepo domicilioRepo;
    @Override
    public DOMICILIO create(DOMICILIO domicilio) {
        return domicilioRepo.save(domicilio);
    }

    @Override
    public Collection<DOMICILIO> list(int limit) {
        return domicilioRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOMICILIO get(Long id) {
        return domicilioRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        domicilioRepo.deleteById(id);
        return TRUE;
    }
}
