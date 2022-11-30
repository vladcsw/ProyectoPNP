package com.example.demo.service.implementation;

import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.model.DOCUMENTO_EMPRESA;
import com.example.demo.repo.DOCUMENTO_EMPRESARepo;
import com.example.demo.service.DOCUMENTO_EMPRESAService;
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
public class DOCUMENTO_EMPRESAServiceImpl implements DOCUMENTO_EMPRESAService {
    private final DOCUMENTO_EMPRESARepo documento_empresaRepo;
    @Override
    public DOCUMENTO_EMPRESA create(DOCUMENTO_EMPRESA documento_empresa) {
        return documento_empresaRepo.save(documento_empresa);
    }

    @Override
    public Collection<DOCUMENTO_EMPRESA> list(int limit) {
        return documento_empresaRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public DOCUMENTO_EMPRESA get(Long id) {
        return documento_empresaRepo.findById(id).orElse(null);
    }
    
    @Override
    public Boolean delete(Long id) {
        documento_empresaRepo.deleteById(id);
        return TRUE;
    }
}
