package com.example.demo.service.implementation;

import com.example.demo.model.EMPRESA;
import com.example.demo.model.EMPRESA;
import com.example.demo.repo.EMPRESARepo;
import com.example.demo.service.EMPRESAService;
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
public class EMPRESAServiceImpl implements EMPRESAService {
    private final EMPRESARepo empresaRepo;
    @Override
    public EMPRESA create(EMPRESA empresa) {
        return empresaRepo.save(empresa);
    }

    @Override
    public Collection<EMPRESA> list(int limit) {
        return empresaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public EMPRESA get(Long id) {
        return empresaRepo.findById(id).get();
    }

    @Override
    public Boolean delete(Long id) {
        empresaRepo.deleteById(id);
        return TRUE;
    }
}
