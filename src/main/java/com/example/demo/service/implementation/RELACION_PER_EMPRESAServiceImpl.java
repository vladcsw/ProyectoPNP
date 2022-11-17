package com.example.demo.service.implementation;

import com.example.demo.model.RELACION_PER_EMPRESA;
import com.example.demo.model.RELACION_PER_EMPRESA;
import com.example.demo.repo.RELACION_PER_EMPRESARepo;
import com.example.demo.service.RELACION_PER_EMPRESAService;
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
public class RELACION_PER_EMPRESAServiceImpl implements RELACION_PER_EMPRESAService {
    private final RELACION_PER_EMPRESARepo relacion_per_empresaRepo;
    @Override
    public RELACION_PER_EMPRESA create(RELACION_PER_EMPRESA relacion_per_empresa) {
        return relacion_per_empresaRepo.save(relacion_per_empresa);
    }

    @Override
    public Collection<RELACION_PER_EMPRESA> list(int limit) {
        return relacion_per_empresaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public RELACION_PER_EMPRESA get(Long id) {
        return relacion_per_empresaRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        relacion_per_empresaRepo.deleteById(id);
        return TRUE;
    }
}
